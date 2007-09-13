/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The ProtExpress
 * Software was developed in conjunction with the National Cancer Institute
 * (NCI) by NCI employees and 5AM Solutions, Inc. (5AM). To the extent
 * government employees are authors, any rights in such works shall be subject
 * to Title 17 of the United States Code, section 105.
 *
 * This ProtExpress Software License (the License) is between NCI and You. You (or
 * Your) shall mean a person or an entity, and all other entities that control,
 * are controlled by, or are under common control with the entity. Control for
 * purposes of this definition means (i) the direct or indirect power to cause
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares,
 * or (iii) beneficial ownership of such entity.
 *
 * This License is granted provided that You agree to the conditions described
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up,
 * no-charge, irrevocable, transferable and royalty-free right and license in
 * its rights in the ProtExpress Software to (i) use, install, access, operate,
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the ProtExpress Software; (ii) distribute and
 * have distributed to and by third parties the ProtExpress Software and any
 * modifications and derivative works thereof; and (iii) sublicense the
 * foregoing rights set out in (i) and (ii) to third parties, including the
 * right to license such rights to further third parties. For sake of clarity,
 * and not by way of limitation, NCI shall have no right of accounting or right
 * of payment from You or Your sub-licensees for the rights granted under this
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the
 * above copyright notice, this list of conditions and the disclaimer and
 * limitation of liability of Article 6, below. Your redistributions in object
 * code form must reproduce the above copyright notice, this list of conditions
 * and the disclaimer of Article 6 in the documentation and/or other materials
 * provided with the distribution, if any.
 *
 * Your end-user documentation included with the redistribution, if any, must
 * include the following acknowledgment: This product includes software
 * developed by 5AM and the National Cancer Institute. If You do not include
 * such end-user documentation, You shall include this acknowledgment in the
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "5AM"
 * to endorse or promote products derived from this Software. This License does
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or 5AM, except as required to comply with the
 * terms of this License.
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this
 * Software into Your proprietary programs and into any third party proprietary
 * programs. However, if You incorporate the Software into third party
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software
 * into such third party proprietary programs and for informing Your
 * sub-licensees, including without limitation Your end-users, of their
 * obligation to secure any required permissions from such third parties before
 * incorporating the Software into such third party proprietary software
 * programs. In the event that You fail to obtain such permissions, You agree
 * to indemnify NCI for any claims against NCI by such third parties, except to
 * the extent prohibited by law, resulting from Your failure to obtain such
 * permissions.
 *
 * For sake of clarity, and not by way of limitation, You may add Your own
 * copyright statement to Your modifications and to the derivative works, and
 * You may provide additional or different license terms and conditions in Your
 * sublicenses of modifications of the Software, or any derivative works of the
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, 5AM SOLUTIONS, INC. OR THEIR
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.data.persistent.Experiment;
import gov.nih.nci.protexpress.data.persistent.ExperimentRun;
import gov.nih.nci.protexpress.data.persistent.Person;
import gov.nih.nci.protexpress.xml.xar2_2.ContactType;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentArchiveType;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentRunType;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentType;
import gov.nih.nci.protexpress.xml.xar2_2.ObjectFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Format conversion helper class for the Xar.xml 2.2 format.
 *
 * @author Krishna Kanchinadam
 */

public class Xar22FormatConversionHelper {

    private ObjectFactory objectFactory = new ObjectFactory();

    /**
     * Default constructor.
     *
     */
    public Xar22FormatConversionHelper() {

    }

    /**
     * Gets the objectFactory.
     *
     * @return the objectFactory.
     */
    public ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    /**
     * Sets the objectFactory.
     *
     * @param objectFactory the objectFactory to set.
     */
    public void setObjectFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }


    /**
     * Given a XAR 2.2 Experiment Archive data, converts it to the internal data model.
     *
     * @param experimentArchive the experiment archive
     * @return the list of experiments.
     */
    public List<Experiment> parseExperimentArchiveData(ExperimentArchiveType experimentArchive) {

        List<Experiment> experiments = getExperimentList(experimentArchive);
        experiments = setExperimentRunsForExperiment(experimentArchive, experiments);

        return experiments;
    }

    /**
     * Given a list of Experiment objects, creates and returns an ExperimentArchiveType.
     *
     * @param experiments the list of experiments
     * @return an ExperimentArchiveType
     */
    public ExperimentArchiveType getExperimentArchiveData(List<Experiment> experiments) {
        ExperimentArchiveType xarExperimentArchiveType = getExperimentTypes(experiments);
        xarExperimentArchiveType.setExperimentRuns(getExperimentRuns(experiments));

        return xarExperimentArchiveType;
    }

    /**
     * Given a XAR 2.2 ExperimentArchiveType, returns a list of Experiments.
     *
     * @param experimentArchive the experiment archive
     * @return the list of experiments.
     */
    private List<Experiment> getExperimentList(ExperimentArchiveType experimentArchive) {
        List<Experiment> experiments = new ArrayList<Experiment>();
        for (ExperimentType xarExperimentType : experimentArchive.getExperiment()) {
            Experiment experiment = getExperiment(xarExperimentType);
            experiments.add(experiment);
        }
        return experiments;
    }

    /**
     * Given a list of Experiment, returns a XAR 2.2 ExperimentArchiveType.
     *
     * @param experiments the list of Experiment
     * @return the ExperimentArchiveType
     */
    private ExperimentArchiveType getExperimentTypes(List<Experiment> experiments) {
        ExperimentArchiveType xarExperimentArchiveType = objectFactory.createExperimentArchiveType();
        for (Experiment exp : experiments) {
            ExperimentType xarExperimentType = objectFactory.createExperimentType();
            xarExperimentType.setAbout(exp.getLsid());
            xarExperimentType.setComments(exp.getComments());
            xarExperimentType.setExperimentDescriptionURL(exp.getUrl());
            xarExperimentType.setHypothesis(exp.getHypothesis());
            xarExperimentType.setName(exp.getName());

            // Set the Contact Person.
            xarExperimentType.setContact(getContactType(exp.getPrimaryContact()));

            //Add to experiment archive
            xarExperimentArchiveType.getExperiment().add(xarExperimentType);
        }

        return xarExperimentArchiveType;
    }

    /**
     * Given a XAR 2.2 ExperimentType, parses it and returns an Experiment.
     *
     * @param xarExperimentType the experiment type
     * @return the experiment
     */
    private Experiment getExperiment(ExperimentType xarExperimentType) {
        Experiment experiment = new Experiment(xarExperimentType.getAbout(),
                xarExperimentType.getName());
        experiment.setComments(xarExperimentType.getComments());
        experiment.setHypothesis(xarExperimentType.getHypothesis());
        experiment.setUrl(xarExperimentType.getExperimentDescriptionURL());

        // Get the Primary Contact Person, if present
        Person experimentPrimaryContact = getPerson(xarExperimentType.getContact());
        experiment.setPrimaryContact(experimentPrimaryContact);

        return experiment;
    }

    /**
     * Given a XAR 2.2 ExperimentArchiveType, returns a list of Experiments.
     *
     * @param experimentArchive the experiment archive
     * @return the list of experiments.
     */
    private List<Experiment> setExperimentRunsForExperiment(ExperimentArchiveType experimentArchive,
            List<Experiment> experiments) {
        HashMap<String, Experiment> experimentMap = new HashMap<String, Experiment>();
        for (Experiment exp : experiments) {
            experimentMap.put(exp.getLsid(), exp);
        }

        for (ExperimentRunType xarExpRunType : experimentArchive.getExperimentRuns().getExperimentRun()) {
            ExperimentRun expRun = getExperimentRun(xarExpRunType);

            // If ExperimentLSID specified, then set the experiment. Else...
            Experiment exp = null;
            if ((xarExpRunType.getExperimentLSID() != null) && (xarExpRunType.getExperimentLSID().length() != 0)) {
                exp = experimentMap.get(xarExpRunType.getExperimentLSID());
           } else {
                if (experiments.size() == 1) {
                    exp = experiments.get(0);
                }
            }

            if (exp != null) {
                exp.getExperimentRuns().add(expRun);
                expRun.setExperiment(exp);
            }
        }
        return experiments;
    }

    /**
     * Given a list of Experiment objects, returns ExperimentArchiveType.ExperimentRuns.
     *
     * @param experiments the list of Experiment
     * @return the ExperimentArchiveType.ExperimentRuns object
     */
    private ExperimentArchiveType.ExperimentRuns getExperimentRuns(List<Experiment> experiments) {
        ExperimentArchiveType.ExperimentRuns xarExperimentRuns = objectFactory.
        createExperimentArchiveTypeExperimentRuns();
        for (Experiment exp : experiments) {
            for (ExperimentRun expRun : exp.getExperimentRuns()) {
                ExperimentRunType xarExperimentRunType = objectFactory.createExperimentRunType();
                xarExperimentRunType.setAbout(expRun.getLsid());
                xarExperimentRunType.setExperimentLSID(expRun.getExperiment().getLsid());
                xarExperimentRunType.setComments(expRun.getComments());
                xarExperimentRunType.setName(expRun.getName());

                xarExperimentRuns.getExperimentRun().add(xarExperimentRunType);
            }
        }

        return xarExperimentRuns;
    }

    /**
     * Given a XAR 2.2 ExperimentRunType, parses it and returns an ExperimentRun.
     *
     * @param xarExperimentRunType the experiment run type
     * @return the experiment run
     */
    private ExperimentRun getExperimentRun(ExperimentRunType xarExperimentRunType) {
        ExperimentRun expRun = new ExperimentRun(xarExperimentRunType.getAbout(), xarExperimentRunType.getName());
        expRun.setComments(xarExperimentRunType.getComments());
        return expRun;
    }

    /**
     * Given a XAR 2.2 ContactType, returns a Person.
     *
     * @param xarContactType the contact type
     * @return the person
     */
    private Person getPerson(ContactType xarContactType) {
        Person experimentPrimaryContact = new Person();
        if (xarContactType != null) {
            experimentPrimaryContact.setFirstName(xarContactType.getFirstName());
            experimentPrimaryContact.setLastName(xarContactType.getLastName());
            experimentPrimaryContact.setContactId(xarContactType.getContactId());
            experimentPrimaryContact.setEmail(xarContactType.getEmail());
        }
        return experimentPrimaryContact;
    }

    /**
     * Given a Person, returns a XAR 2.2 ContactType.
     *
     * @param person the person
     * @return xarContactType the contact type
     */
    private ContactType getContactType(Person person) {
        ContactType xarContactType = objectFactory.createContactType();
        if (person != null) {
            xarContactType.setContactId(person.getContactId());
            xarContactType.setEmail(person.getEmail());
            xarContactType.setFirstName(person.getFirstName());
            xarContactType.setLastName(person.getLastName());
        }
        return xarContactType;
    }
}

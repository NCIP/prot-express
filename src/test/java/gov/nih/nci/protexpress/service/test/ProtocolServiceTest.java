package gov.nih.nci.protexpress.service.test;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.data.persistent.Protocol;
import gov.nih.nci.protexpress.data.persistent.ProtocolType;
import gov.nih.nci.protexpress.service.ProtocolSearchParameters;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.displaytag.properties.SortOrderEnum;

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

/**
 * @author Scott Miller
 */
public class ProtocolServiceTest extends ProtExpressBaseHibernateTest {

    @SuppressWarnings("unchecked")
    public void testSaveRetrieveDeleteProtocol() throws Exception {
        Protocol p = new Protocol("test protocol 1", ProtocolType.ExperimentRun);
        p.setInstrument("foo");
        p.setDescription("bar");
        p.setSoftware("baz");

        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);

        theSession.flush();
        theSession.clear();

        Protocol p2 = (Protocol) ProtExpressRegistry.getProtocolService().getProtocolById(p.getId());
        assertEquals(p, p2);

        ProtExpressRegistry.getProtocolService().deleteProtocol(p2);

        theSession.flush();
        theSession.clear();

        List<Protocol> protocolList = theSession.createQuery("from " + Protocol.class.getName()).list();
        assertEquals(0, protocolList.size());
    }

    @SuppressWarnings("unchecked")
    public void testSearchProtocols() throws Exception {
        Protocol p = new Protocol("test protocol 1", ProtocolType.ExperimentRun);
        p.setDescription("bar 123");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);

        p = new Protocol("test protocol 12", ProtocolType.ExperimentRunOutput);
        p.setDescription("bar 12");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);

        p = new Protocol("test protocol 123", ProtocolType.SamplePrep);
        p.setDescription("bar 1");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);

        theSession.flush();
        theSession.clear();

        Iterator<Protocol> protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, null,
                null);
        assertEquals(3, IteratorUtils.toList(protocolIt).size());
        assertEquals(3, ProtExpressRegistry.getProtocolService().countMatchingProtocols(null));

        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, "name",
                SortOrderEnum.ASCENDING);
        String lastVal = null;
        while (protocolIt.hasNext()) {
            p = protocolIt.next();
            if (lastVal != null) {
                assertTrue(p.getName().compareTo(lastVal) >= 0);
            }
        }

        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, "name",
                SortOrderEnum.DESCENDING);
        lastVal = null;
        while (protocolIt.hasNext()) {
            p = protocolIt.next();
            if (lastVal != null) {
                assertTrue(p.getName().compareTo(lastVal) <= 0);
            }
        }

        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, "description",
                SortOrderEnum.ASCENDING);
        lastVal = null;
        while (protocolIt.hasNext()) {
            p = protocolIt.next();
            if (lastVal != null) {
                assertTrue(p.getDescription().compareTo(lastVal) >= 0);
            }
        }

        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, "description",
                SortOrderEnum.DESCENDING);
        lastVal = null;
        while (protocolIt.hasNext()) {
            p = protocolIt.next();
            if (lastVal != null) {
                assertTrue(p.getDescription().compareTo(lastVal) <= 0);
            }
        }

        ProtocolSearchParameters params = new ProtocolSearchParameters();
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(3, IteratorUtils.toList(protocolIt).size());
        assertEquals(3, ProtExpressRegistry.getProtocolService().countMatchingProtocols(params));

        params.setTypes(new ArrayList<ProtocolType>());
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(3, IteratorUtils.toList(protocolIt).size());

        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 2, 0, null, null);
        assertEquals(2, IteratorUtils.toList(protocolIt).size());
        assertEquals(3, ProtExpressRegistry.getProtocolService().countMatchingProtocols(params));

        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 2, 1, null, null);
        assertEquals(2, IteratorUtils.toList(protocolIt).size());

        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 2, null, null);
        assertEquals(1, IteratorUtils.toList(protocolIt).size());

        params.setName("a");
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(0, IteratorUtils.toList(protocolIt).size());

        params.setName("test prot");
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(3, IteratorUtils.toList(protocolIt).size());

        params.setDescription("bar ");
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(3, IteratorUtils.toList(protocolIt).size());

        List<ProtocolType> types = new ArrayList<ProtocolType>();
        types.add(ProtocolType.ExperimentRun);
        types.add(ProtocolType.ExperimentRunOutput);
        types.add(ProtocolType.SamplePrep);
        params.setTypes(types);
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(3, IteratorUtils.toList(protocolIt).size());

        params.setName("test protocol 12");
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(2, IteratorUtils.toList(protocolIt).size());

        params.setDescription("bar 12");
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        List<Protocol> protocolList = IteratorUtils.toList(protocolIt);
        assertEquals(1, protocolList.size());
        assertEquals(ProtocolType.ExperimentRunOutput.getDisplayName(), protocolList.get(0).getType().getDisplayName());

        types = new ArrayList<ProtocolType>();
        types.add(ProtocolType.ExperimentRun);
        types.add(ProtocolType.SamplePrep);
        params.setTypes(types);
        protocolIt = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(0, IteratorUtils.toList(protocolIt).size());
    }

    public void testEqualsAndHashCode() {
        assertFalse(new Protocol("test", ProtocolType.ExperimentRun).equals(new Protocol("test",
                ProtocolType.ExperimentRun)));
        Protocol p1 = new Protocol("test protocol 1", ProtocolType.ExperimentRun);
        p1.setInstrument("foo");
        p1.setDescription("bar");
        p1.setSoftware("baz");

        assertFalse(p1.equals(null));
        assertFalse(p1.equals(new String("Foo")));
        assertTrue(p1.equals(p1));
        assertEquals(p1.hashCode(), new Protocol("test protocol 1", ProtocolType.ExperimentRun).hashCode());
    }
}
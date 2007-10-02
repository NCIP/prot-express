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
package gov.nih.nci.protexpress.data.persistent;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.Length;

/**
 * Class representing a Simple Value Type (name, value and a URI).
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "simple_value_type")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SimpleTypeValue implements Serializable, Persistent {

    private static final long serialVersionUID = 1L;

    private static final int NAME_LENGTH = 255;
    private static final int TYPE_LENGTH = 255;
    private static final int VALUE_LENGTH = 255;
    private static final int URI_LENGTH = 255;

    private Long id;
    private String name;
    private SimpleType valueType;
    private String ontologyEntryURI;
    private String value;


    /**
     * protected default constructor for hibernate only.
     */
    protected SimpleTypeValue() {
    }

    /**
     * Constructor to create the object with a short name and a fully-qualified name (ontology entry uri).
     *
     * @param name the short name
     * @param uri the ontology entry uri
     * @param valueType the value type
     */
    public SimpleTypeValue(String name, String uri, SimpleType valueType) {
        setName(name);
        setOntologyEntryURI(uri);
        setValueType(valueType);
    }

    /**
     * The id of the object.
     *
     * @return the id, null for new objects
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name.
     */
    @Column(name = "name")
    @Length(max = NAME_LENGTH)
    public String getName() {
        return name;
    }


    /**
     * Sets the name.
     *
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the valueType.
     *
     * @return the valueType.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "value_type", length = TYPE_LENGTH)
    public SimpleType getValueType() {
        return valueType;
    }


    /**
     * Sets the valueType.
     *
     * @param valueType the valueType to set.
     */
    public void setValueType(SimpleType valueType) {
        this.valueType = valueType;
    }


    /**
     * Gets the ontologyEntryURI.
     *
     * @return the ontologyEntryURI.
     */
    @Column(name = "ontology_uri")
    @Length(max = URI_LENGTH)
    public String getOntologyEntryURI() {
        return ontologyEntryURI;
    }


    /**
     * Sets the ontologyEntryURI.
     *
     * @param ontologyEntryURI the ontologyEntryURI to set.
     */
    public void setOntologyEntryURI(String ontologyEntryURI) {
        this.ontologyEntryURI = ontologyEntryURI;
    }

    /**
     * Gets the value.
     *
     * @return the value.
     */
    @Column(name = "value")
    @Length(max = VALUE_LENGTH)
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!(o instanceof SimpleTypeValue)) {
            return false;
        }

        SimpleTypeValue svt = (SimpleTypeValue) o;

        if (this.id == null) {
            return false;
        }

        return new EqualsBuilder()
        .append(getName(), svt.getName())
        .append(getOntologyEntryURI(), svt.getOntologyEntryURI())
        .append(getValueType().toString(), svt.getValueType().toString())
        .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
        .append(getName())
        .append(getOntologyEntryURI())
        .append(getValueType().toString())
        .toHashCode();
    }

}

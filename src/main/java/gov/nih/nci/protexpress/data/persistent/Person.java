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
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
 * Class representing an experiment.
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int NAME_LENGTH = 100;
    private static final int EMAIL_LENGTH = 255;
    private static final int PHONE_LENGTH = 25;
    private static final int FAX_LENGTH = 25;
    private static final int URL_LENGTH = 255;
    private static final int COMMENTS_LENGTH = 255;

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private String fax;
    private String url;
    private String comments;
    private String organizationName;
    private String organizationUrl;

    private Address address;

    /**
     * Constructor to create the object and populate all required fields.
     */
    public Person() {
    }

    /**
     * The id of the object.
     *
     * @return the id, null for new objects
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the firstName.
     *
     * @return the firstName
     */
    @Column(name = "first_name")
    @Length(max = NAME_LENGTH)
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the firstName.
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the middleName.
     *
     * @return the middleName.
     */
    @Column(name = "middle_name")
    @Length(max = NAME_LENGTH)
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middleName.
     *
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets the lastName.
     *
     * @return the lastName
     */
    @Column(name = "last_name")
    @Length(max = NAME_LENGTH)
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    @Column(name = "email")
    @Length(max = EMAIL_LENGTH)
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    @Column(name = "phone")
    @Length(max = PHONE_LENGTH)
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the fax.
     *
     * @return the fax
     */
    @Column(name = "fax")
    @Length(max = FAX_LENGTH)
    public String getFax() {
        return fax;
    }

    /**
     * Sets the fax.
     *
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    @Column(name = "url")
    @Length(max = URL_LENGTH)
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the comments.
     *
     * @return the comments
     */
    @Column(name = "comments")
    @Length(max = COMMENTS_LENGTH)
    public String getComments() {
        return comments;
    }

    /**
     * Sets the comments.
     *
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the organizationName.
     *
     * @return the organizationName
     */
    @Column(name = "org_name")
    @Length(max = NAME_LENGTH)
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the organizationName.
     *
     * @param organizationName the organizationName to set
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * Gets the organizationUrl.
     *
     * @return the organizationUrl
     */
    @Column(name = "org_url")
    @Length(max = URL_LENGTH)
    public String getOrganizationUrl() {
        return organizationUrl;
    }

    /**
     * Sets the organizationUrl.
     *
     * @param organizationUrl the organizationUrl to set
     */
    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    /**
     * @return the address
     */
    @Embedded
    public Address getAddress() {
        return this.address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Person person = (Person) obj;

        if (id == null) {
            return false;
        }

        return new EqualsBuilder().append(getId(), person.getId()).append(getFirstName(), person.getFirstName())
                .append(getLastName(), person.getLastName()).isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).append(getFirstName()).append(getLastName()).toHashCode();
    }

}

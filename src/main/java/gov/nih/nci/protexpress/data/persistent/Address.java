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
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

/**
 * Class representing an experiment.
 *
 * @author Krishna Kanchinadam
 */
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int ADDRESS_LINE_LENGTH = 100;
    private static final int CITY_LENGTH = 25;
    private static final int STATE_LENGTH = 25;
    private static final int COUNTRY_LENGTH = 50;
    private static final int ZIP_LENGTH = 10;

    private String streetaddress1;
    private String streetaddress2;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    /**
     * protected default constructor for hibernate only.
     */
    public Address() {
    }

    /**
     * Gets the line1.
     *
     * @return the line1.
     */
    @Column(name = "streetaddress1")
    @NotEmpty
    @Length(max = ADDRESS_LINE_LENGTH)
    public String getStreetAddress1() {
        return streetaddress1;
    }

    /**
     * Sets the line1.
     *
     * @param line1 the line1 to set.
     */
    public void setStreetAddress1(String line1) {
        this.streetaddress1 = line1;
    }

    /**
     * Gets the line2.
     *
     * @return the line2.
     */
    @Column(name = "streetaddress2")
    @Length(max = ADDRESS_LINE_LENGTH)
    public String getStreetAddress2() {
        return streetaddress2;
    }

    /**
     * Sets the line2.
     *
     * @param line2 the line2 to set.
     */
    public void setStreetAddress2(String line2) {
        this.streetaddress2 = line2;
    }

    /**
     * Gets the city.
     *
     * @return the city.
     */
    @Column(name = "city")
    @Length(max = CITY_LENGTH)
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     *
     * @return the state.
     */
    @Column(name = "state")
    @Length(max = STATE_LENGTH)
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the country.
     *
     * @return the country.
     */
    @Column(name = "country")
    @NotEmpty
    @Length(max = COUNTRY_LENGTH)
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country the country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the zipCode.
     *
     * @return the zipCode.
     */
    @Column(name = "zip_code")
    @NotEmpty
    @Length(max = ZIP_LENGTH)
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zipCode.
     *
     * @param zipCode the zipCode to set.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Address address = (Address) obj;

        return new EqualsBuilder().append(getStreetAddress1(), address.getStreetAddress1()).append(getCountry(),
                address.getCountry()).append(getZipCode(), address.getZipCode()).isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getStreetAddress1()).append(getCountry()).append(getZipCode()).toHashCode();
    }

}

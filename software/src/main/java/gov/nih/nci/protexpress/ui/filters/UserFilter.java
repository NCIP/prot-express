/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.filters;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.util.UserHolder;
import gov.nih.nci.security.authorization.domainobjects.User;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * filter to add the currently logged in user to the {@link UserHolder}.
 *
 * @author Scott Miller
 */
public class UserFilter implements Filter {

    /**
     * {@inheritDoc}
     */
    public void destroy() {
    }

    /**
     * {@inheritDoc}
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }
        String username = ((HttpServletRequest) request).getRemoteUser();
        if (StringUtils.isNotBlank(username)) {
            User user = ProtExpressRegistry.getUserProvisioningManager().getUser(username);
            if (user == null) {
                user = new User();
                user.setLoginName(username);
            }
            UserHolder.setUser(user);
            request.setAttribute("currentUser", UserHolder.getUser());
            request.setAttribute("currentUserDisplayName", UserHolder.getDisplayNameForUser());
        } else {
            UserHolder.setUser(null);
        }
        chain.doFilter(request, response);
    }

    /**
     * {@inheritDoc}
     */
    public void init(FilterConfig config) throws ServletException {
    }
}

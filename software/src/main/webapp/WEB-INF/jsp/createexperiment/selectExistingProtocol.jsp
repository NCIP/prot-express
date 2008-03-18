<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<!--Protocol List-->

                                    <div style="text-align:right; padding:0 20px 0 0;">
                                        <input type="checkbox" name="" id="" /> Display Protocols created by all users
                                    </div>

                                <div class="tabbed">


                                    <div class="searchresults">

                                        <table class="newdata3">
                                            <tr>
                                                <th class="order1"><a href="#">Protocol Name</a></th>
                                                <th><a href="#">Description</a></th>
                                                <th><a href="#">Notes</a></th>
                                                <th><a href="#">User</a></th>

                                                <th class="actionwide">Action</a></th>
                                            </tr>
                                            <tr class="odd">
                                                <td class="title">Protocol A</td>
                                                <td>Sample description</td>
                                                <td>Sample notes</td>
                                                <td><a href="mailto:kkanchinadam@email.com">kkanchinadam</a></td>

                                                <td class="actionwide">
                                                    <del class="btnwrapper">
                                                        <ul id="btnrow2">
                                                            <li><a href="experimentcreate_protocols2.htm" class="btn" style="text-decoration:none" onclick="this.blur();"><span class="btn_img"><span class="add">Select and Continue</span></span></a></li>
                                                        </ul>
                                                    </del>
                                                </td>
                                            </tr>
                                            <tr class="even">

                                                <td class="title">Protocol B</td>
                                                <td>Sample description</td>
                                                <td>Sample notes</td>
                                                <td><a href="mailto:kkanchinadam@email.com">kkanchinadam</a></td>
                                                <td class="actionwide">
                                                    <del class="btnwrapper">
                                                        <ul id="btnrow2">
                                                            <li><a href="experimentcreate_protocols2.htm" class="btn" style="text-decoration:none" onclick="this.blur();"><span class="btn_img"><span class="add">Select and Continue</span></span></a></li>

                                                        </ul>
                                                    </del>
                                                </td>
                                            </tr>
                                            <tr class="odd">
                                                <td class="title">Protocol C</td>
                                                <td>Sample description</td>
                                                <td>Sample notes</td>

                                                <td><a href="mailto:kkanchinadam@email.com">kkanchinadam</a></td>
                                                <td class="actionwide">
                                                    <del class="btnwrapper">
                                                        <ul id="btnrow2">
                                                            <li><a href="experimentcreate_protocols2.htm" class="btn" style="text-decoration:none" onclick="this.blur();"><span class="btn_img"><span class="add">Select and Continue</span></span></a></li>
                                                        </ul>
                                                    </del>
                                                </td>
                                            </tr>

                                        </table>

                                        <!--Paging-->

                                        <div class="pagecontrol">

                                            <p class="small">Displaying <strong>1-3</strong> of <strong>3</strong> Total.</p>

                                            <div class="paging">
                                                    Page 1
                                                &nbsp;&nbsp;

                                                &lt; Back <span class="bar">|</span>
                                                Next &gt;
                                            </div>

                                        </div>

                                        <!--/Paging-->

                                    </div>

                                </div>

                                <!--/Protocol List-->

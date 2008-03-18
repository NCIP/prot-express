<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<form name="create" id="createnew">

                                    <div class="twocoltable">
                                        <table class="form">
                                            <tr>
                                                <td class="label">Protocol Name:</td>

                                                <td class="value"><input type="text" name="title" id="exptitle" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td class="label">Description:</td>
                                                <td class="value"><textarea cols="20" rows="2" id="desc" style="height:70px"></textarea></td>
                                            </tr>
                                        </table>
                                    </div>


                                    <div class="twocoltable">
                                        <table class="form">
                                            <tr>
                                                <td class="label">Software:</td>
                                                <td class="value"><input type="text" id="software" maxlength="150" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td class="label">Instrument:</td>

                                                <td class="value"><input type="text" id="instrument" maxlength="150" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td class="label">Notes:</td>
                                                <td class="value"><textarea cols="20" rows="2" id="expcomments"></textarea></td>
                                            </tr>
                                        </table>
                                    </div>


                                    <div class="clear"></div>

                                    <div class="actionsrow">

                                        <del class="btnwrapper">

                                            <ul id="btnrow2">
                                                <li><a href="experimentcreate.htm" class="btn" onclick="this.blur();"><span class="btn_img"><span class="cancel">Cancel/Back</span></span></a></li>
                                                <li><a href="experimentcreate_protocols2.htm" class="btn" style="text-decoration:none" onclick="this.blur();"><span class="btn_img"><span class="savecontinue">Save and Continue</span></span></a></li>
                                            </ul>

                                        </del>

                                        <div class="clear"></div>

                                    </div>


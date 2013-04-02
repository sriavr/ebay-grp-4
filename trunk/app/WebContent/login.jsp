<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row">
	<div class="large-6 columns">
		<s:form action="login.action" method="post">
		
			<s:if test="hasActionErrors()">
			<div class="panel">
							<br />
							<s:iterator value="actionErrors">
								<div data-alert class="alert-box alert">
								 <a href="#" class="close">&times;</a>
									<s:property />
								</div>
							</s:iterator>
			</div>				
						</s:if>
			<div class="panel">



				<font size="4"><b>Sign In</b>
				</font><br><br> User ID
				<s:textfield theme="simple" name="userName"
					placeholder="Enter email Id" />
				<br> Password
				<s:password theme="simple" name="password"
					placeholder="Enter Password" />
				<br>


				

					
				
			</div>

            <div class="panel">
            <input type="submit" class="small button round" value="Login" />
            </div>


		</s:form>
	</div>
	
	<div class="large-6 columns">
	<div class="panel">
	 <font size="5"><b>New to eBay?</b></font><br><br>
	 
	 <a href="register.action" class="small button round">Register</a>
	 
	 </div>
	</div>

</div>
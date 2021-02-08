# AutomationPractice
<p><b><h3>Overview</b></h3>
<p>This project covers:
<br>● Development of a small test automation framework in <b>Java</b>
<br>● Behaviour Driven Development (BDD) using <b>Cucumber</b>
<br>● RESTful API testing - using <b>RestAssured</b> 
<br>● Selenium WebDriver web testing - using <b>Page Object Model</b> and <b>Page Factory</b><br/> 
<p>&nbsp;</p> 

<p><b><h4>API test cases</b></h4>
<p>1. Successful registration
<br>● POST on https://reqres.in/api/register
<br>● Payload: email and password
<br>● Response: 201 along with a token

<p>2. Unsuccessful registration
<br>● POST on https://reqres.in/api/register
<br>● Payload: email
<br>● Response: 400 along with an error
   
<p>3. Get User List
<br>● GET on https://reqres.in/api/users
<br>● No payload
<br>● Response: 200 with list of users
<p>&nbsp;</p> 

<p><b><h4>WEB test cases</b></h4>
<b>URL for tests:</b>AutomationPractice.com
<br>● Sign in with no credentials. Ensure the correct error message is displayed.
<br>● Sign in with email and empty password. Ensure the correct error message is displayed.
<br>● Sign in with password and empty email. Ensure the correct error message is displayed.
<br>● Sign in with incorrect credentials. Ensure the correct error message is displayed.

# AtmMachineLocApi

1. I have created a REST api, that exposes end point using which we can fetch list of ING ATMs for a given city.
2. For above implmentation, I created a maven project using sprinboot. Also added required dependencies.
3. Coded using Java 8 using Stream, Optional etc. 
4. I started with adding  Controller where I added method "fetchAtmsInfo" with input as city.
   Following that I added Service and Dao layer. In Dao i'm calling https://www.ing.nl/api/locator/atms/ for fetching required atm locations based on city.
5. I have used spring security for validating username and password:
   In Spring security config file, i'm authenticating using AuthenticationManagerBuilder
   username -> admin
   password -> password
6. Please use the below url for logging : 
   http://localhost:8081/fetchAtmsInfo/Schiermonnikoog. Here city can be any value that can be fetched from https://www.ing.nl/api/locator/atms/
7. Also i have covered all the required Junit test cases using Mockito.

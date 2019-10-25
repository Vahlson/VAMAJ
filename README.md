# VAMAJ
[![BCH compliance](https://bettercodehub.com/edge/badge/Legetic/VAMAJ?branch=master)](https://bettercodehub.com/)

The use of solar power for both commercial and private uses is a growing trend. This project aims to adopt that trend by providing value to the user through information about their potential gains with solar power. The user can through the program see whether solar power would be a viable investment economically as well as if there would be a future possibility of profit. The comparisons are made based on the users current electricity provider. Furthermore a major part of the aim of the program is to highlight environmental effect through comparison of ecological footprint before and after the potential switch. This is meant to further incentivize the user towards investing in solar power. The user should also be assisted in his or her choice of solar panel so that a good balance between cost and environmental benefits can be achieved. The program aims to help private residents as well as businesses to help with the decision process concerning the acquirement and use of solar power.

If you have issues running the application:
The application should start fine, even if the database file cannot be found, or if internet connection is missing.
If you get the error message "Error loading database! Path to database may be incorrect.", it means that the program cannot find the path to the database file, and therefore cannot get your location data. To fix this issue, follow these steps:

Navigate to the 'GeolocationService' class. In the constructor, at line 28, the database is loaded from the given url. If this url is not working, you will need to change it. To get the correct url for the database, find the database file in the project package structure, under src -> main -> resources -> databases -> geolocation. In there, you should find a file called 'GeoLite2-City.mmdb". Right click on this file and select 'Copy Path". When you have copied the path, open the GeolocationService class again. Just over line 28, where the database is loaded, type 'url = "the path that you copied earlier"; It might look something like this: 
url = "C:\\Users\\User\\Documents\\VAMAJ\\src\\main\\resources\\databases\\geolocation\\GeoLite2-City.mmdb";
Now, when you launch the application, everything should work as expected.

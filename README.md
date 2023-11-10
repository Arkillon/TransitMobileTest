# TransitMobileTest
# by Marc-André Paquin

Questions :
• How long did it take you to complete the project?
- About 7 hours spread over 3 days

• What part of this project did you find most challenging?
- I was trying to add a polygon on google map to show the area covered by a feed when we click on it, but somehow it was very slow, would need more investigation !

• If you used 3rd party libraries, explain for each one the reason for introducing that
dependency and how you selected that particular library.
- Jetpack Compose - Preferred way to build UI and has BottomSheet component included
- Google map : Its the most used map library and it support jetpack compose so it was a no brainer for this test app
- Retrofit - Choosed this networking library as I think that with the GsonConverter to convert JSON to model classes it makes it really easy to work with APIs
- Hilt - I prefer to add DI at the beginning of a project to decrease coupling between classes

• Given 8 more hours, how would you improve your project
- Improve performance on the map, as there is a lot of feed markers, probably want to cache the custom pin bitmaps, etc
- Add caching/local DB for the feed list
- Improve UI/UX & add some animations
- Center on current userLocation & permission handling
- add tests
- Better handle API requests (failures, errors)
* Could go for better architecture such as clean architecture with 3 modules (UI layer, domain, data layer) with Interfaces between layers & use cases
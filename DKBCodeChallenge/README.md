DKB Code Challenge
------------
Android app that showcases architecture and libraries used by me.
There are two simple pages to show basic implementations followed.
PhotosList screen to show the list of the Photo that got by endPoint and Photo Detail Screen to show extra information about the Photo.

Architecture
------------
Single Activity
MVVM Pattern
Jetpack Compose
ViewModel: Can have simple UI logic but gets the data from UseCase
Repository: Single source of data. Responsible to get data from one or more data sources (in this project Remote datasource)

Tech Stack
------------
Navigation Graph: Implemented by JetpackCompose
Flow: Lifecycle aware observable and data holder
ViewModel: Holds UI data across configuration changes
Hilt: Dependency injector
Coroutines: Asynchronous programming
Retrofit: Type safe HTTP client
GSON: JSON serializer/deserializer

Two thing that solved well
------------
  - Implemented domain layer with two type of UseCases, one simple UseCase and one UseCase class that inherit from
    a base class and I wanted to show both could be able to implemented.
  - the Presentation layer implemented by Jetpack Compose and the screen is reusable in other scenarios only need pass
        the data that necessary. 
  - a custom ServerResponse class that handle the status of the Loading,Error,Success,Fail and could later implement 
        the loading or Toast or SingleLiveEvent for informing the User.

Two thing that would improve
------------
   - the result of Api has huge number and should implement the pagination, I could get data with type flow Paging data of the 
        compose and get in the screen get them as collectAsLazyPagingItems.(implementing a paging class for loading)
   - I could implement with on ViewModel ( a Shared ViewModel) for getting the for list and detail page, and implement
        two usecases in a dataClass.
   - 
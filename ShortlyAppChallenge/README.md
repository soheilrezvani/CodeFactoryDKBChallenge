MAYD Code Challenge
------------
Android app that showcases architecture and libraries used by me.
There is one simple pages to show basic implementations followed.
a list of Apis that get data by a api call and save them into DB
and with a copy button can copy the shortened link in clip board

I put three items types in the list 
   1. empty list 
   2. header
   3. items

I implement this project in clean code architecture with MVVM in presentation layer
the logic handled in domain layer by some UseCases, data handled by two data sources (remote and local)
the modules injected by the hilt
the database implement by the Room
this adapter has an issue for handling the last item in list(the last item is redundant)
but the copy and copied status and handled in clipboard properly handled in the code but not in the UI
If I had more time I could solve this issue

Architecture
------------
Single Activity
MVVM Pattern
View: Renders UI and delegates user actions to ViewModel
ViewModel: Can have simple UI logic but most of the time just gets the data from Repository
Repository: Single source of data. Responsible to get data from data sources
UseCase: Handling logics and from viewModels to Repository

Tech Stack
------------
LiveData: Lifecycle aware observable and data holder
ViewModel: Holds UI data across configuration changes
Databinding: Binds UI components in layouts to data sources
Hilt: Dependency injector
Coroutines: Asynchronous programming
JUNIT4: unit testing



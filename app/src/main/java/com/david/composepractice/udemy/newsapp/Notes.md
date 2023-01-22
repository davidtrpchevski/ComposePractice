For navigation with arguments, we need to set the argument in curly brackets (ex. Details/{key})

For scrolling in column, we need to add .verticalScroll(scrollState) to the Modifier

If we have something to fetch, we store it as MutableStateFlow. After that, we assign it to a
StateFlow.
To collect the value from that state flow, we use: viewModel.stateFlow.collectAsState()
(ex. homeViewModel.newsArticles.collectAsState())
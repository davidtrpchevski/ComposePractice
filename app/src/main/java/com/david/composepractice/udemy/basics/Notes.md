Every function created by use, that uses composable requires to be annotated with @Composable Column
helps us place items in vertical order, one below another Rows helps us place items in a horizontal
order, one next to another Image requires to have painterResource and contentDescription (this can
be null)
By default, the preview annotation doesn't show background. If we want to have background we need to
have showBackground set to true.

Modifiers are used to change the appearances and behaviours of the composables.
Modifier.fillMaxSize() take the entire space of the screen for us. (for Column, take the entire
width available)
Modifier.verticalScroll() sets the direction of which the content can be scrolled. Usually we go
with rememberScrollState()
If we want to change the shape of the Card, we use the shape parameter instead of the one in
Modifier.


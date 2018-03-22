#Group 5
> ###Tania, Bakhodir, Jamsrandorj


####How our system works?
> We have framework, UI for framework, and Controller for framework.
>  
> In terms of implementing Framework, we create new Class which is extends from Finco. /BankFinco.java, CreditCardFinco.java/
> 
> When we run Bank or Credit card they will call their own Controller. /BankController.java, CreditCardController.java/
> 
> And the controller will draw the specific window using Framework's template UI. Call the template UI, add specific buttons, table and so on.
> 
> When user click anything, it will call their own listener and let them do their functions.
> 
> When user click anything, it will call their own listener and let them do their functions.
>
> For example: click Add user, we call popup window from framewrok and add fields into it. It is what controller do.
>  
####Used Design Patterns: Observer, Account, Party, Simple, Strategy, Singleton, Proxy factory

####Observer Pattern
> We used this pattern to implement addInterest Function. All accounts are observers when user clicks addInterest button it will invoke.

####Party Pattern
> We used party pattern to generalize the common Customer data and methods.

####Account Pattern
> We used this pattern to generalize the common Account infos.

####Simple Factory
> We used this pattern to create Person or Company type of Customer. 

####Strategy Pattern
> We used this pattern to change the strategy of withDraw and Deposit functions. We have one common function and when we implement this pattern we can change the strategy.

####Proxy Pattern
> We used this pattern to implement the logging and notifying customer functions. After calling the function itself we do logging and call the message methods. These methods are receiving Predicate, so in this case we generalize. P2C -> P2I

####Singleton Pattern
> We used this pattern to save history. If we save history then we can generate reports easily.

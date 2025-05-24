# Test without spring feature with mockito 
In 3 layer architect we can separate concern. In unit test each layer will be test separate. So we  will make sure the fault of other layer will be problem for current layer to test. 

Instead of use spring to automatic create mock layer for test we can manually create the mock repository in. Let try to make mock object and test our service. 


This mean we will not use any `@Mock` or `@InjectMock` to create mock dependency and inject it automatically. 


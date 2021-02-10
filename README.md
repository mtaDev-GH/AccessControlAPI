# AccessControlAPI

A spring-boot RestAPI that implements the acces control to the app endpoints using spring security.

It controll acces by privileges every user can have a set of privilieges attributes to him which serves to define the endpoints a user can exploit.

Profiles are used to regroup a set of privileges, so instead of attributing the same set of privileges for every user of a certain kind we attribute privileges to a profile and we attribute the profile to the user.

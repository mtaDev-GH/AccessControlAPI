# AccessControlAPI

A spring-boot RestAPI that implements the acces control to the app endpoints using spring security.

It controll acces by privileges, every user can have a set of privilieges attributed to him which serves to define the endpoints a user can exploit.

Profiles are used to regroup a set of privileges, so instead of attributing the same set of privileges for every user of a certain kind we attribute privileges to a profile then the user gets those privileges just by attributing that profile to him.

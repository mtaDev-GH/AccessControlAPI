# AccessControlAPI

A spring-boot RestAPI that implements the control of acces to the app endpoints using spring security.

It controll acces by privileges (roles), every user can have a set of privilieges that helps determine the endpoints a user can exploit.

Profiles are used to regroup a set of privileges, they are used to avoid repetedly a same set of privileges one by oen to a user. Instead the set of privileges is attributed to a profile which is given users.
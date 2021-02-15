# AccessControlAPI

A spring-boot RestAPI that implements the control of acces to the app endpoints using spring security (Basic authentication).

It controll acces by privileges (roles), every user can have a set of privilieges that helps determine the endpoints (rest services) a user can exploit.

Profiles are used to regroup a set of privileges, they help avoid repetedly attributing a same set of privileges one by oen to users with the same privileges. Instead the set of privileges is attributed to a profile which is given to the users.

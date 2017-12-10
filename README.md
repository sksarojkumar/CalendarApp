# CalenderApp
A GUI Application that show Calender with some features.
In this app we can add *Events* `(like Birthday, Anniversary)` and on that date you *saved Message* sent to that person automatically or you can also send by yourself.

# Prerequisite   
You need to install following software:
* Java 7
* Oracle 10g database  
and create a *One table* named:
 1. EventList `(for save your events)`
 ```
 EventId    Number,
 Name       Varchar2,
 EventName  Varchar2,
 EventDate  Date,
 Email      Varchar2,
 Msg        Varchar2
 ```

# ScreenShorts
 * Calendar:
 
 ![Calendar](https://github.com/sksarojkumar/CalendarApp/blob/master/screenshort/main.png)
 
 * Event Add Frame:
 
 ![Event Frame](https://github.com/sksarojkumar/CalendarApp/blob/master/screenshort/event.png)

# Build With:
* Swing Framework
* Thread

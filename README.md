# Movie-Reservation-App

## Project Description

In this project our task was to analyze, design, and develop a system that can be used by two group of users: ordinary users that can search for a movie, select an specific theater, view available show times, view graphically available seats, select the desired seat, make payment by credit card, receive a copy of ticket and the receipt, via email. Users also should be able to cancel their ticket only up to 72 hours prior to show and receive a credit with %15 administration fee for future purchase up maximum of one-year expiration date. The other group of users are those who must be registered (let’s call them Registered Users, RUs), and their information such as name, address, credit and/or debit card account must be saved on the system’s database. RUs must pay a $20.00 annual account fee, but they don't have to pay 15% admin fee for cancelling their tickets and will receive the movie news before public announcement. There is also one more constraint: Only 10% of the seats can be purchased by RUs on a first come first serve policy prior to public announcements.

We had to include the following documents along with our source code: systems use case diagram, systems activity diagram, state transition diagrams, detailed scenarios for each use case, systems interaction diagrams, design level class specification, package diagram, deployment diagram. These documents are included in the ProjectDesign.pdf.

## How to Run

To run this program we recommend using a java IDE to execute the FrontEndGUI.java file in the guiView package.

## App Features

Starting the app, the user is presented with 3 options: Guest, Registered User and to Register.

![](screenshots/1.png)

Clicking Register brings the user to this screen, allowing them to enter their information. To keep the app as simple as possible we opted just to have registered users enter their email and no password, as the verification was not part of the exercise.

![](screenshots/2.png)

Clicking Guest allows the user to either purchase a ticket or cancel a ticket. Purchasing a ticket will then bring the user to a screen where they can select a movie, then a time (for this example the user is using the app on Dec 1 2020), then seat, and then they enter their information and voucher number if they have one.

![](screenshots/3.png)
![](screenshots/4.png)
![](screenshots/5.png)
![](screenshots/6.png)

After clicking Purchase Ticket, the app then "prints" the ticket in a dialogue box and returns to the main menu.

![](screenshots/7.png)

To cancel the Ticket, a guest user needs to enter their ticket number on the cancellation page after being taken there by the guest menu.

![](screenshots/8.png)

The after cancelling the ticket, the voucher is "printed".

![](screenshots/9.png)

If the user is a registered user, they will be asked to login.

![](screenshots/10.png)

This will then bring the user to their registered user menu. If they have not paid their user fee, the options to book and cancel a ticket are not available.

![](screenshots/11.png)

The user can pay this fee by clicking the Pay User Fee button and are then asked to confirm payment.

![](screenshots/12.png)

The confirmation is "printed" and user is returned to the registered user menu.

![](screenshots/13.png)

If the user wants to see news, they can select Get Movie News and see the news screen, then are returned to the registered user menu.

![](screenshots/14.png)

The user can book a ticket using the same method selection methods as a guest user, without entering their info at the end. Instead they have their own screen where they can pay via credit card or voucher.

![](screenshots/15.png)

Their ticket is then "printed and they are returned to the main menu.

![](screenshots/16.png)

The registered user cancellation screen allows the user to select which movie ticket they'd like to cancel.

![](screenshots/17.png)

After confirming their cancellation, the app "prints" the confirmation of the cancellation and adds a $10 voucher to the user's account, which can be used to purchase another ticket.

![](screenshots/18.png)
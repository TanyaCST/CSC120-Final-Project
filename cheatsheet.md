//is it okay to not have help?
//Readme.md nt reflection.md?
This file will contain documentation for all commands available in your game.
Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

''' NOTE: We do not have a help command because the interactive nature of the game largely instructs the user on what to do next in each step. ''' For example, when prompted to select an equipment, we show the user what equipments they can choose from.
## Also, the main method in SurgicalRobot (the parent class) is to test the functionalities of the methods implemented. The real game is in the subclasses' main methods. We ask that when grading the logic/accuracy/efficiency of the game, you grade each person based on the class assigned to them, ie BainRobot for Tanya, HeartRobot for Olohi, and LiverRobot for Tanya. Other things like underlying story (which is largely the same), architecture diagram, etc, can be graded as a group.

# SPOILER ALERT
If your game includes challenges that must be overcome to win, also list them below.

#PARENT CLASS: SurgicalRobot.java#
*equipment* -- When prompted to enter an equipment, enter only one of the equipment listed:
forceps,
syringes,
scissors
lint,
wool,
x-ray scan,
advil,
sewing thread,
suction tubes,
surgical knives,
blue fluorescent light,
ultrasound,
microscope,
surgical needle and suture,
bandages,
blood sugar meters,
scalpel,
retractor,
surgical knives,
rongeurs,
elctrocautery device, 
surgical suction device,

#BRANCH CLASS: Brain.java#

Brain.java contains 3 surgeries. Users can choose to start the game with one of the game by pressing:

1- hemorrage

2- hematoma

3- brain tumor

If user wants to leave, press 4 at the beginning. After 1/2 rounds of game, type in *no*.

3 surgeries share the same design:
There is a patient who *might* have hemorrage/hematoma/brain tumor and *might* need a surgery.

The grading() method will determine whether this patient has such problem. 
grading >= 5
The patient needs a surgery. User can ask for guideline by pressing 2. The guide will show the equipments needed & proper treatments/methods of surgery.

In the surgery, the user can grab equipments  (available equipments will be printed out one by one), add description of equipment (what is this equipments used for), and the usage of equipment (what do you want to do with this equipment).

If you are done with the surgery, type in yes to choose another surgery or quit the game. If not, type in no to grab another equipment and use it.

After you finished the surgery, the program will regrade your patient's health.
-if grading > 5: the patient survives. the surgery is successful.
-if grading < 5: the patient dies.

grading < 5
The patient does not need a surgery. type in yes to choose another surgery or quit the game.

grading.max = 10
grading.min = 1


#BRANCH CLASS: HeartRobot.java#

1- YES
2- NO

HeartRobot.java consists of three levels:
Level 1---transplant(): This simply determines whether the user can move to level 2 or 3, depending on the heart damage level. If the damage level of the heart is greater than a certain threshold, the user automatically gets promoted to level 3. If less, they'll be required to pass through level 2 first. where they'll be expected to replace the heart. If less than the stipulated threshold, the user passes through level 2 first during which they get to just graft a new artery and ultimatle replace the heart after completing level 2 if they choose to.

Level 2--- graftArtery(): At this stage, the user is expected to perfrom a simple artery graft stitching if the damage level of the heart is less than 6. They can move to level 3 after completing this level if they want, but it is not required.

Level 3--- heartReplace(): At this final stage, the user gets to replace the heart and earn more points. Depending on how long the replacement takes, the patient may die or live.

max number of points that can be earned = 90
min number of points that can be earned = 20

#BRANCH CLASS: Liver.java#
LiverRobot.java consists of four different operations based on a randomized number of patient condition severity from 0 to 6. The purpose of these is to walk the player through each step and familiarize people with the general steps of liver surgeries, while explaining their purpose.

Severity Level 0 - diagnosticLaproscopy(): The player must follow the steps to enter text and perform a diagnostic laproscopy step by step on a patient. If they do not enter the correct word, they cannot move on.

Severity Level 1 - liverResection(): The player must follow the steps to enter text and perform a liver resection step by step on a patient. If they do not enter the correct word, they cannot move on.

Severity Level 2 - liverAblation(): The player must follow the steps to enter text and perform a radiofrequency liver ablation. If they do not enter the correct word, they cannot move on.

Severity Level 3+ - liverTransplant(): The player must follow the steps to perform a liver transplant by entering the correct text. They cannot move on unless they enter the correct word.

As there is lower risk of fatality during liver surgeries compared to heart and brain surgeries, there is no possibility of the patient dying.

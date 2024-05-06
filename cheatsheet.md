This file will contain documentation for all commands available in your game.
Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.
# SPOILER ALERT
If your game includes challenges that must be overcome to win, also list them below.

#PARENT CLASS: SurgicalRobot.java#
*equipment* -- When prompted to enter an equipment, enter only one of the equipments listed:
forceps
syringes
scissors
lint
wool
x-ray scan
advil
sewing thread
suction tubes
surgical knives
blue fluorescent light
ultrasound
microscope
surgical needle and suture
bandages
blood sugar meters
scalpel
retractor
surgical knives
rongeurs
elctrocautery device
surgical suction device

#BRANCH CLASS: Brain.java#

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

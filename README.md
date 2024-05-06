# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
   - Our overall approach was to plan the project out accordingly, figure out what we wanted to implement, and what we thought we might not have enough time to implement. We also tried to effectively communicate, staying in contact with each other for each step so that we were aware of what each of us were implementing.

 - What **new thing(s)** did you learn / figure out in completing this project?
    - **Olohi:** reading files into a program, making a hashtable that stored several features of a key, working with a team, and making a program pause during execution(was really cool).
    - **Tanya:** using random to choose between 2 numbers; let java pause for a few seconds before the next output; we can’t use the same scanner variable to loop, otherwise it will cause an exception.
    - **Emily:** making sure the scanner doesn’t go into an infinite loop, and that using one scanner is enough, with just a need to change the scanner variables

 - Is there anything that you wish you had **implemented differently**?
- A major implementation that would have made the game more organized and intriguing would involve having the main methods of all three games in a main file. We were wondering if it’s possible to implement an overarching main method that asks the user what type of surgery they want to perform and then redirects them to the surgery type in question depending on their responses. This could probably be done in two ways. The first one might involve copying and pasting the main methods of each subclass into a main file and then putting each in an if loop. An example would be:
```
if (userResponse.equals(“brain”){
	//brain main method}
```
- However, we reasoned a potential limitation would be figuring out if the subclass’ methods can be called outside the subclass, especially if multiple subclasses have the same call signature for a method (but overridden to work based on the context of the surgery type). 

- The second sounded more logical, but we weren’t sure if it was an implementable strategy: we were wondering if it’s possible to link the methods in the main file. Example:
```
 if (userResponse.equals(“brain”){
	Brain.java}
```
 - In this case, the user will just be redirected to the main methods of each subclass depending on their choice. 

 - If you had **unlimited time**, what additional features would you implement?
    - Two major additional features we were considering include:
      
      Implementing the graph we mapped at the start of the project: We made a little geographical map, such that to pick equipment, the surgeon will be required to move to a certain location, eg. (2,3), and if the user tries moving to a restricted place, eg. trying to move into a wall, we’ll throw an exception (“Sorry, you just walked into a wall. Retrace your steps!”) This will definitely make the game more difficult for the user but will enhance user’s involvement and promote more intellectual reasoning.
      
      A second, as explained, in the previous question, will be to merge the main methods of all subclasses into one overarching main method.

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
    - **Olohi:** Create a class to store multiple attributes of the keys in your Hashtable— Jordan
    - **Emily:** Regarding the scanner variable being renewed each time – Jordan
    - **Tanya:** Create a file for equipments and use read file instead of creating multiple Hashtable - Jordan
  
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
    - **Emily:** Plan your project out before starting. It definitely helps, as you know what you’re doing, instead of aimlessly trying to implement methods.
    - **Olohi:** Don’t freak out too much. Everything will work out! Just focus on having fun with the project and start early (I did great on this one). Starting early significantly reduces the tension and makes the learning process more fun.
    - **Tanya:** Start early. Implement your design while coding. Don’t wait to start until you finish your design. Test more so that you can find bugs early.

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
    - **Olohi:** The fact this was a teamwork project definitely made it way more intriguing. There were certain ideas my teammates brought that I wouldn’t have come up with. I also tend to be “stay safe, do what we can in the scope of time” usually. However, as my groupmates brought seemingly undoable ideas, I was able to break this mindset and dare to attempt certain tasks
    - **Emily:** Having groupmates that were productive made me more productive, and helped adherence to deadlines. Moreover, different opinions on similar things helped me gain new perspectives as to how things could be implemented.
    - **Tanya:** Having teammates really made our project more interesting. In the stage of brainstorming, having groupmates brought me a lot of new sparks such as creating map to implement movement (though we end up not using it), using buffer reader, making java pause for a few seconds before running the next line. These are ideas I wouldn't have if I didn’t group up with them.


/*Hellow,
 *
 * This class will fill your forum with some Messages and Users
 * The messages are part of the "INT. APARTMENT (ROOM 49) - MORNING      " scene in the movie "PULP FUICTION.
 * The users are the actors.
 *
 * Just Put it somewhere and this file along. Shift-F6
 *
 * you can find part of this in those URL
 * http://www.youtube.com/watch?v=HePWBNcugf8
 * http://www.youtube.com/watch?v=xcxF9oz9Cu0
 *
 *   John Travolta as Vincent Vega
 *   Uma Thurman as Mia Wallace
 *   Ving Rhames as Marsellus Wallace
 *   BRETT
 *   ROGER
 *   FOURTH MAN
 *   MARVIN
 *
 *  * Have FUN!!
 *
 * */
package Forum;

import Forum.DomainLayer.Forum;
import Forum.PersistentLayer.Interfaces.ForumHandlerInterface;
import Forum.PersistentLayer.SQLForumHandler;
import java.util.Date;

import org.junit.Test;

/**
 *
 * @author Amit Ofer
 */
public class PulpTest {

    public PulpTest() {
    }

    ForumHandlerInterface fH = new SQLForumHandler();
    Forum instance = Forum.getInstance();

    /**
     * Test of register method, of class Forum.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("PulpFiction FUll the forum");
   ////////   fH.initForum();/////////////////// Dont use it !! it will format your DATA BASE
        Date tDate = new Date();
        int num;
        instance.register("Jules", "jjjjjjjj",  "Jules","Winnfield@jules.com", "Samuel", "Jackson", tDate);
        instance.register("Vincent", "vvvvvvvv",  "Vega","@Vincent.com", "John", "Travolta", tDate);
        instance.register("Mia", "mmmmmmmm","Mia",  "Wallace@Mia.com", "Uma", "Thurman", tDate);
        instance.register("Marsellus", "mmmmmmmm","Marsellus", "Wallace@Marsellus.com",  "Ving", "Rhames", tDate);
        instance.register("BRETT", "bbbbbbbb","BRETT",  "@BRETT.com", "Bob", "deBert", tDate);
        instance.register("ROGER", "rrrrrrrr", "ROGER", "@ROGER.com", "Don", "deRoger", tDate);
        instance.register("FOURTH", "ffffffff","FOURTH", "MAN@FOURTH.com",  "Mopy", "arba", tDate);
        instance.register("MARVIN", "mmmmmmmm",  "MARVIN", "MARVIN@.com","Dol", "Knoth", tDate);
        num = instance.addMessage("JULES", "Start", "Hey kids");
        num = instance.addMessage("JULES", "Start 2", "How you boys doin'?");
        num = instance.addMessage("JULES", "Start 3", "Am I trippin', or did I just ask you a question.");
        instance.addReply(num, "BRETT", "Start2 answer", " We're doin' okay.");
        num = instance.addMessage("JULES", "how we are ", " Do you know who we are?");
        instance.addReply(num, "BRETT", "how we are answer", " shakes his head: No.");
        instance.addReply(num, "JULES", "how we are", " We're associates of your business partner Marsellus Wallace, you remember your business partner dont'ya?");
        num = instance.addMessage("JULES", "knowing others", " Now I'm gonna take a wild guess here: you're BRETT, right?");
        instance.addReply(num, "BRETT", "Brett", " I'm BRETT.");
        instance.addReply(num, "JULES", "question to Brett", " I thought so.  Well, you remember your business partner Marsellus Wallace, dont'ya BRETT?");
        instance.addReply(num, "BRETT", "Answer", " I remember him.");
        num = instance.addMessage("JULES", "The Hamburgers", " Good for you.  Looks like me and VINCENT caught you at breakfast, sorry 'bout that.  What'cha eatin'?");
        instance.addReply(num, "BRETT", "Hamburgers", " Hamburgers.");
        instance.addReply(num, "JULES", "Hamburgers", " Hamburgers.  The cornerstone of any nutritious breakfast.  What kinda hamburgers?");
        instance.addReply(num, "BRETT", "Cheeseburgers", " Cheeseburgers.");
        num = instance.addMessage("JULES", "Place of buying", " No, I mean where did you get'em? MacDonald's, Wendy's, Jack-in-the- Box, where?");
        instance.addReply(num, "BRETT", "Big Kahuna 1", " Big Kahuna Burger.");
        instance.addReply(num, "JULES", "Big Kahuna 2", " Big Kahuna Burger.  That's that Hawaiian burger joint.  I heard they got some tasty burgers.  I ain't never had one myself, how are they?");
        instance.addReply(num, "BRETT", "Big Kahuna 3", " They're good.");
        num = instance.addMessage("JULES", "Try to taste 1", " Mind if I try one of yours?");
        instance.addReply(num, "BRETT", "Try to taste 2", " No.");
        instance.addReply(num, "JULES", "Try to taste 3", " Yours is this one, right?");
        instance.addReply(num, "BRETT", "Try to taste 4", " Yeah.");
        instance.addReply(num, "JULES", "Try to taste5", " grabs the burger and take a bite of it.");
       num = instance.addMessage("JULES", "Big Kahuna 1", " Uuummmm, that's a tasty burger.      (to VINCENT) Vince, you ever try a Big Kahuna Burger?");
        instance.addReply(num, "VINCENT", "Big Kahuna 2", " No.");
        instance.addReply(num, "JULES", "Big Kahuna 3", " holds out the Big Kahuna.");
        instance.addReply(num, "JULES", "Big Kahuna 4", " You wanna bite, they're real good.");
        instance.addReply(num, "VINCENT", "Big Kahuna 5", " I ain't hungry.");
        num = instance.addMessage("JULES", "Hamburgers 1", " Well, if you like hamburgers give 'em a try sometime.  Me, I can't usually eat 'em 'cause my girlfriend's a vegetarian.  Which more or less makes me a vegetarian, but I sure love the taste of a good burger.   ");
        num = instance.addMessage("JULES", "Hamburgers 2", "   (to BRETT) You know what they call a Quarter Pounder with Cheese in France?");
        instance.addReply(num, "BRETT", "Royale with Cheese. 1", " No.");
        instance.addReply(num, "JULES", "Royale with Cheese. 2", " Tell 'em, VINCENT.");
        instance.addReply(num, "VINCENT", "Royale with Cheese. 3", " Royale with Cheese.");
        num = instance.addMessage("JULES", "Sourse of name", " Royale with Cheese, you know why they call it that?");
        instance.addReply(num, "BRETT", "Sourse of name", " Because of the metric system?");
        instance.addReply(num, "JULES", "Sourse of name 2", " Check out the big brain on BRETT. You'a smart motherfucker, that's right.  The metric system.    (he points to a fast food drink cup) What's in this?");
        instance.addReply(num, "BRETT", "Sourse of name 3", " Sprite.");
        instance.addReply(num, "JULES", "Sourse of name 4", " Sprite, good, mind if I have some of your tasty beverage to wash this down with?");
        instance.addReply(num, "BRETT", "Sourse of name 5", " Sure.");
        instance.addReply(num, "JULES", "Sourse of name 6", " grabs the cup and takes a sip.");
        num = instance.addMessage("JULES", "Why we here 1", " Uuuuummmm, hit's the spot!      (to ROGER) You, Flock of Seagulls, you know what we're here for?");
        instance.addReply(num, "ROGERaddReply", "Why we here 2", " nods his head: Yes.");
        num = instance.addMessage("JULES", " The thing 1", " Then why don't you tell my boy here Vince, where you got the shit hid.");
        instance.addReply(num, "MARVIN", "  The thing 2", " It's under the be --");
        instance.addReply(num, "JULES", " The thing 3", " -- I don't remember askin' you a goddamn thing. (to OGER) You were sayin'?");
        instance.addReply(num, "ROGER", " The thing 4", " It's under the bed.");
        instance.addReply(num, "VINCENT", " The thing 5", " moves to the bed, reaches underneath it, pulling out a black snap briefcase.");
        instance.addReply(num, "VINCENT", " The thing 6", " Got it.");
        instance.addReply(num, "VINCENT", " The thing 7", " flips the two locks, opening the case. We can't see what's inside, but a small glow emits from the case. ");
        num = instance.addMessage("JULES", "We happy 1", " We happy?");
        instance.addReply(num, "JULES", "We happy 2", " VINCENT!");
        instance.addReply(num, "VINCENT", "We happy 3", " looks up at JULES.");
        instance.addReply(num, "JULES", "We happy 4", " We happy?");
        instance.addReply(num, "VINCENT", "We happy 5", " We're happy.");
        num = instance.addMessage("BRETT", "", " Look, what's your name?  I got his name's VINCENT, but what's yours?");
        instance.addReply(num, "JULES", "", " My name's Pitt, and you ain't talkin' your ass outta this shit.");
        instance.addReply(num, "BRETT", "", " I just want you to know how sorry we are about how fucked up things got between us and Mr. Wallace. When we enterednumo this thing, we only had the bestnumentions --");
        instance.addReply(num, "BRETT", "", " has just shit his pants.  He's not crying or whimpering, but he's so full of fear, it's as if his body is imploding.");
        num = instance.addMessage("JULES", "concentration", "      (to BRETT) Oh, I'm sorry.  Did that break your concentration?");
        num = instance.addMessage("JULES", "bestnumentions", "  I didn't mean to do that.  Please, continue.  I believe you were saying something about ^bestnumentions^.");
        instance.addReply(num, "BRETT", "bestnumentions", " can't say a word.");
        num = instance.addMessage( "JULES", " what Marsellus Wallace looks like?", " Whatsamatter?  Oh, you were through anyway.  Well, let me retort. Would you describe for me what Marsellus Wallace looks like?");
        instance.addReply(num,"JULES", " what Marsellus Wallace looks like? 1", " What country you from!");
        instance.addReply(num, "BRETT", " what Marsellus Wallace looks like? 2", "      (petrified) What?");
        instance.addReply(num, "JULES", " what Marsellus Wallace looks like? 3", " ^What^ ain't no country I know!  Do they speak English in ^What?^");
        instance.addReply(num, "BRETT", " what Marsellus Wallace looks like?  4", "      (near heart attack) What?");
        instance.addReply(num, "JULES", " what Marsellus Wallace looks like? 5", " English-motherfucker-can-you-speak- it?");
        instance.addReply(num, "BRETT", " what Marsellus Wallace looks like? 6", " Yes.");
        instance.addReply(num, "JULES", " what Marsellus Wallace looks like? 7", " Then you understand what I'm sayin'?");
        instance.addReply(num, "BRETT", " what Marsellus Wallace looks like? 8", " Yes.");
        instance.addReply(num, "JULES", " what Marsellus Wallace looks like? 9", " Now describe what Marsellus Wallace looks like!");
        instance.addReply(num, "BRETT", " What?", "      (out of fear) What?");
        instance.addReply(num, "JULES", "What?", " takes his .45 and PRESSES the barrel HARD in BRETT's cheek.");
        num = instance.addMessage("JULES", "Marsellus Wallace looks like!", " Say ^What^ again!  C'mon, say ^What^ again!  I dare ya, I double dare ya motherfucker, say ^What^ one more goddamn time!");
        instance.addReply(num, "BRETT", "Marsellus Wallace looks like!", " is regressing on the spot.");
        instance.addReply(num, "JULES", "Marsellus Wallace looks like!", " Now describe to me what Marsellus Wallace looks like!");
        instance.addReply(num, "BRETT", "Marsellus Wallace looks like!", " does his best.");
        instance.addReply(num, "BRETT", "Marsellus Wallace looks like!", "   Well he's ...he's...black --");
        instance.addReply(num, "JULES", "Marsellus Wallace looks like!", "   -- go on!-");
        instance.addReply(num, "BRETT", "Marsellus Wallace looks like!", "   ...and he's...he's...tall ---");
        instance.addReply(num, "JULES", "Marsellus Wallace looks like!", "   -- does he look like a bitch?!");
        instance.addReply(num, "BRETT", "Marsellus Wallace looks like!", "        (without thinking)   What?");
        instance.addReply(num, "JULES", "Marsellus Wallace looks like!", " eyes go to VINCENT, VINCENT smirks, JULES rolls his eyes and SHOOT BRETT in the shoulder.");
        instance.addReply(num, "BRETT", "Marsellus Wallace looks like!", " SCREAMS, breakingnumo a SHAKING/TREMBLING SPASM in the chair.");
        instance.addReply(num, "JULES", "Marsellus Wallace looks like!", "   Does-he-look-like-a-bitch?!");
        instance.addReply(num, "BRETT", "Marsellus Wallace looks like!", "        (in agony)   No.");
        instance.addReply(num, "JULES", "Marsellus Wallace looks like!", "   Then why did you try to fuck 'im   like a bitch?!");
        instance.addReply(num, "BRETT", "Marsellus Wallace looks like!", "        (in spasm)   I didn't.");
        num = instance.addMessage("JULES", " the Bible", " Yes ya did BRETT.  Ya tried ta fuck 'im.  You ever read the Bible, BRETT?");
        instance.addReply(num, "BRETT", " the Bible", "      (in spasm) Yes.");
        num = instance.addMessage("JULES", "  Ezekiel 25:17  1", " There's a passage I got memorized, seems appropriate for this situation: Ezekiel 25:17. The path of the righteous man is beset on all sides by the inequities of");
        num = instance.addMessage("JULES", "  Ezekiel 25:17  2", "the selfish and the tyranny of evil men.  Blessed is he who, in the name of charity and good will, shepherds the weak through the valley of darkness, for he ");
        num = instance.addMessage("JULES", " Ezekiel 25:17  3", "is truly his brother's keeper and the finder of lost children.  And I will strike down upon thee with great vengeance and furious anger those who attempt to");
        num = instance.addMessage("JULES", " Ezekiel 25:17  4", "poison and destroy my brothers.  And you will know my name is the Lord when I lay my vengeance upon you.");
        num = instance.addMessage("MARVIN", " Ezekiel 25:17  5", " ...goddamn...goddamn...that was fucked up...goddamn, that was cold- blooded...");
        instance.addReply(num, "VINCENT", "Friend of yours 1", "      (pointing to MARVIN) Friend of yours?");
        instance.addReply(num, "JULES", "Friend of yours 2", " Yeah, MARVIN-VINCENT-VINCENT- MARVIN.");
        instance.addReply(num, "VINCENT", "Friend of yours 3", " Tell 'em to shut up, he's gettin' on my nerves.");
        instance.addReply(num, "JULES", "Friend of yours 4", " MARVIN, I'd knock that shit off if I was you.");
        instance.addReply(num, "FOURTH MAN", "Friend of yours 5", " Die...die...die...die...die...");
        instance.addReply(num, "FOURTH MAN", " I don't understand", " I don't understand --");


    }

}

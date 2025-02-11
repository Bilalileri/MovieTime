package de.hwg_lu.bw.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class MovieApp {

Connection dbConn;
	
	public static void main(String[] args) throws SQLException {
		MovieApp myApp = new MovieApp();
		myApp.dbConn = new PostgreSQLAccess().getConnection();
		myApp.doSomething();
	}
	
	
	public void doSomething() throws SQLException {
        this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Review");
        this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Account");
        this.executeUpdateWithoutParms("DROP TABLE IF EXISTS Movie");
        this.executeUpdateWithoutParms("DROP TABLE IF EXISTS BucketList");
        this.createTableMovie();
        this.createTableAccount();
        this.createTableReview();
        this.createTableBucketList();
        this.insertDataMovie();
        this.insertDataReview();
    }
    
    public void executeUpdateWithoutParms(String sql) throws SQLException{
        System.out.println(sql);
        this.dbConn.prepareStatement(sql).executeUpdate();
    }
    
    public void createTableMovie() throws SQLException {
        this.executeUpdateWithoutParms(
            "CREATE TABLE Movie(" + 
                "MovieId INT PRIMARY KEY," + 
                "Title VARCHAR(255) NOT NULL," + 
                "Genre VARCHAR(50) NOT NULL," + 
                "YearOfRelease INT NOT NULL," + 
                "Director VARCHAR(255) NOT NULL," + 
                "ImdbRating DECIMAL(3,1) NOT NULL," + 
                "BriefIntroduction TEXT NOT NULL" + 
            ")"
        );      
    }
    public void createTableAccount() throws SQLException {
        this.executeUpdateWithoutParms(
            "CREATE TABLE Account(" + 
                "username VARCHAR(50) PRIMARY KEY," + 
                "password VARCHAR(128) NOT NULL," + 
                "age INT NOT NULL," +
                "email VARCHAR(255) NOT NULL," + 
                "sex VARCHAR(50) NOT NULL" + 


            ")"
        );      
    }
    
    public void createTableReview() throws SQLException {
        this.executeUpdateWithoutParms(
            "CREATE TABLE Review(" +
                "ReviewId   SERIAL       PRIMARY KEY," +  
                "MovieId    INTEGER      NOT NULL," + 
                "Review     TEXT         NOT NULL" +
            ")"
        );
    }
    
    public void createTableBucketList() throws SQLException {
        this.executeUpdateWithoutParms(
            "CREATE TABLE Bucketlist(" +
            	"Username   VARCHAR(50)  PRIMARY KEY," +  
                "MovieId    INTEGER[]" + 
                ")"
        );
    }
    
    
    public void insertDataMovie() throws SQLException {
        this.executeUpdateWithoutParms(
            "INSERT INTO Movie (MovieId, Title, Genre, YearOfRelease, Director, ImdbRating, BriefIntroduction) VALUES " +
            "(1, 'The Shawshank Redemption', 'drama', 1994, 'Frank Darabont', 9.3, 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through.'), " +
            "(2, 'The Godfather', 'drama', 1972, 'Francis Ford Coppola', 9.2, 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'), " +
            "(3, 'Schindler''s List', 'drama', 1993, 'Steven Spielberg', 8.9, 'In German-occupDied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.'), " +
            "(4, 'Forrest Gump', 'drama', 1994, 'Robert Zemeckis', 8.8, 'The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other historical events unfold from the perspective of an Alabama man with an IQ of 75.'), " +
            "(5, 'Fight Club', 'drama', 1999, 'David Fincher', 8.8, 'An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into much more.'), " +
            "(6, 'Goodfellas', 'drama', 1990, 'Martin Scorsese', 8.7, 'The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners.'), " +
            "(7, 'The Green Mile', 'drama', 1999, 'Frank Darabont', 8.6, 'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.'), " +
            "(8, 'Saving Private Ryan', 'drama', 1998, 'Steven Spielberg', 8.6, 'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.'), " +
            "(9, 'The Pianist', 'drama', 2002, 'Roman Polanski', 8.5, 'A Polish Jewish musician struggles to survive the destruction of the Warsaw ghetto of World War II.'), " +
            "(10, 'Gladiator', 'drama', 2000, 'Ridley Scott', 8.5, 'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.'), " +
            "(11, 'Inception', 'action', 2010, 'Christopher Nolan', 8.8, 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.'), " +
            "(12, 'The Dark Knight', 'action', 2008, 'Christopher Nolan', 9.0, 'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.'), " +
            "(13, 'Gladiator', 'action', 2000, 'Ridley Scott', 8.5, 'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.'), " +
            "(14, 'Mad Max: Fury Road', 'action', 2015, 'George Miller', 8.1, 'In a post-apocalyptic wasteland, Max teams up with Furiosa to flee from a cult leader and his army.'), " +
            "(15, 'Die Hard', 'action', 1988, 'John McTiernan', 8.2, 'An NYPD officer tries to save his wife and others taken hostage by terrorists during a Christmas party.'), " +
            "(16, 'The Matrix', 'action', 1999, 'Lana Wachowski, Lilly Wachowski', 8.7, 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.'), " +
            "(17, 'Terminator 2: Judgment Day', 'action', 1991, 'James Cameron', 8.5, 'A cyborg, identical to the one who failed to kill Sarah Connor, must now protect her teenage son from a more advanced and powerful cyborg.'), " +
            "(18, 'The Avengers', 'action', 2012, 'Joss Whedon', 8.0, 'Earth''s mightiest heroes must come together to stop a demigod from subjugating humanity.'), " +
            "(19, 'The Bourne Identity', 'action', 2002, 'Doug Liman', 7.9, 'A man is picked up by a fishing boat, bullet-riddled and suffering from amnesia, before racing to elude assassins and regain his memory.'), " +
            "(20, 'Casino Royale', 'action', 2006, 'Martin Campbell', 8.0, 'After earning 00 status and a license to kill, Secret Agent James Bond sets out on his first mission as 007.'), " +
            "(21, 'Lethal Weapon', 'action', 1987, 'Richard Donner', 7.6, 'Two newly paired cops who are complete opposites must put aside their differences in order to catch a gang of drug smugglers.'), " +
            "(22, 'Pulp Fiction', 'comedy', 1994, 'Quentin Tarantino', 8.9, 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.'), " +
            "(23, 'The Big Lebowski', 'comedy', 1998, 'Joel Coen, Ethan Coen', 8.1, 'Jeff \"The Dude\" Lebowski, mistaken for a millionaire of the same name, seeks restitution for his ruined rug and enlists his bowling buddies for help.'), " +
            "(24, 'Groundhog Day', 'comedy', 1993, 'Harold Ramis', 8.1, 'A weatherman finds himself inexplicably living the same day over and over again.'), " +
            "(25, 'Monty Python and the Holy Grail', 'comedy', 1975, 'Terry Gilliam, Terry Jones', 8.2, 'King Arthur and his Knights of the Round Table embark on a surreal, low-budget search for the Holy Grail.'), " +
            "(26, 'Superbad', 'comedy', 2007, 'Greg Mottola', 7.6, 'Two co-dependent high school seniors are forced to deal with separation anxiety after their plan to stage a booze-soaked party goes awry.'), " +
            "(27, 'Anchorman: The Legend of Ron Burgundy', 'comedy', 2004, 'Adam McKay', 7.2, 'Ron Burgundy is San Diego''s top-rated newsman in the male-dominated broadcasting of the 1970s.'), " +
            "(28, 'Step Brothers', 'comedy', 2008, 'Adam McKay', 6.9, 'Two aimless middle-aged losers still living at home are forced against their will to become roommates when their parents marry.'), " +
            "(29, 'Dumb and Dumber', 'comedy', 1994, 'Peter Farrelly, Bobby Farrelly', 7.3, 'After a woman leaves a briefcase at the airport terminal, a dumb limo driver and his dumber friend set out on a hilarious cross-country road trip to Aspen.'), " +
            "(30, 'Tropic Thunder', 'comedy', 2008, 'Ben Stiller', 7.0, 'Through a series of freak occurrences, a group of actors shooting a big-budget war movie are forced to become the soldiers they are portraying.'), " +
            "(31, 'Borat', 'comedy', 2006, 'Larry Charles', 7.3, 'Kazakh TV talking head Borat is dispatched to the United States to report on the greatest country in the world. With a documentary crew in tow, Borat becomes more interested in locating and marrying Pamela Anderson.'), " +
            "(32, 'Shaun of the Dead', 'comedy', 2004, 'Edgar Wright', 7.9, 'A man decides to turn his moribund life around by winning back his ex-girlfriend, reconciling his relationship with his mother, and dealing with an entire community that has returned from the dead to eat the living.'), " +
            "(33, 'The Exorcist', 'horror', 1973, 'William Friedkin', 8.1, 'When a teenage girl is possessed by a mysterious entity, her mother seeks the help of two priests to save her daughter.'), " +
            "(34, 'The Shining', 'horror', 1980, 'Stanley Kubrick', 8.4, 'A family heads to an isolated hotel for the winter where a sinister presence influences the father into violence, while his psychic son sees horrific forebodings from both past and future.'), " +
            "(35, 'Psycho', 'horror', 1960, 'Alfred Hitchcock', 8.5, 'A Phoenix secretary embezzles $40,000 from her employer''s client, goes on the run, and checks into a remote motel run by a young man under the domination of his mother.'), " +
            "(36, 'Alien', 'horror', 1979, 'Ridley Scott', 8.5, 'After a space merchant vessel perceives an unknown transmission as a distress call, one of the crew is attacked by a mysterious life form.'), " +
            "(37, 'Jaws', 'horror', 1975, 'Steven Spielberg', 8.1, 'When a killer shark unleashes chaos on a beach community, it''s up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down.'), " +
            "(38, 'The Silence of the Lambs', 'horror', 1991, 'Jonathan Demme', 8.6, 'A young F.B.I. cadet must confide in an incarcerated and manipulative killer to receive his help on catching another serial killer who skins his victims.'), " +
            "(39, 'A Nightmare on Elm Street', 'horror', 1984, 'Wes Craven', 7.5, 'The monstrous spirit of a slain janitor seeks revenge by invading the dreams of teenagers whose parents were responsible for his untimely death.'), " +
            "(40, 'The Thing', 'horror', 1982, 'John Carpenter', 8.1, 'A research team in Antarctica is hunted by a shape-shifting alien that assumes the appearance of its victims.'), " +
            "(41, 'Get Out', 'horror', 2017, 'Jordan Peele', 7.7, 'A young African-American visits his white girlfriend''s parents for the weekend, where his simmering uneasiness about their reception of him eventually reaches a boiling point.'), " +
            "(42, 'It', 'horror', 2017, 'Andy Muschietti', 7.3, 'In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster, which disguises itself as a clown and preys on the children of Derry, their small Maine town.'), " +
            "(43, 'Hereditary', 'horror', 2018, 'Ari Aster', 7.3, 'A grieving family is haunted by tragic and disturbing occurrences.'), " +
            "(44, 'The Conjuring', 'horror', 2013, 'James Wan', 7.5, 'Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.'), " +
            "(45, 'Titanic', 'romance', 1997, 'James Cameron', 7.8, 'A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.'), " +
            "(46, 'Pride and Prejudice', 'romance', 2005, 'Joe Wright', 7.8, 'Sparks fly when spirited Elizabeth Bennet meets single, rich, and proud Mr. Darcy.'), " +
            "(47, 'The Notebook', 'romance', 2004, 'Nick Cassavetes', 7.8, 'A poor yet passionate young man falls in love with a rich young woman, giving her a sense of freedom, but they are soon separated because of their social differences.'), " +
            "(48, 'La La Land', 'romance', 2016, 'Damien Chazelle', 8.0, 'While navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.'), " +
            "(49, 'Casablanca', 'romance', 1942, 'Michael Curtiz', 8.5, 'A cynical American expatriate struggles to decide whether or not he should help his former lover and her fugitive husband escape French Morocco.'), " +
            "(50, 'A Walk to Remember', 'romance', 2002, 'Adam Shankman', 7.4, 'The story of two North Carolina teens, Landon Carter and Jamie Sullivan, who are thrown together after Landon gets into trouble and is made to do community service.'), " +
            "(51, 'Gone with the Wind', 'romance', 1939, 'Victor Fleming', 8.1, 'A manipulative woman and a roguish man conduct a turbulent romance during the American Civil War and Reconstruction periods.'), " +
            "(52, 'Eternal Sunshine of the Spotless Mind', 'romance', 2004, 'Michel Gondry', 8.3, 'When their relationship turns sour, a couple undergoes a medical procedure to have each other erased from their memories.'), " +
            "(53, 'Romeo + Juliet', 'romance', 1996, 'Baz Luhrmann', 6.7, 'Shakespeare''s famous play is updated to the hip modern suburb of Verona still retaining its original dialogue.'), " +
            "(54, 'Notting Hill', 'romance', 1999, 'Roger Michell', 7.1, 'The life of a simple bookshop owner changes when he meets the most famous film star in the world.'), " +
            "(55, 'The Lord of the Rings: The Fellowship of the Ring', 'fantasy', 2001, 'Peter Jackson', 8.8, 'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.'), " +
            "(56, 'Harry Potter and the Sorcerer''s Stone', 'fantasy', 2001, 'Chris Columbus', 7.6, 'An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family and the terrible evil that haunts the magical world.'), " +
            "(57, 'Pan''s Labyrinth', 'fantasy', 2006, 'Guillermo del Toro', 8.2, 'In the falangist Spain of 1944, the bookish young stepdaughter of a sadistic army officer escapes into an eerie but captivating fantasy world.'), " +
            "(58, 'The Chronicles of Narnia: The Lion, the Witch and the Wardrobe', 'fantasy', 2005, 'Andrew Adamson', 6.9, 'Four kids travel through a wardrobe to the land of Narnia and learn of their destiny to free it with the guidance of a mystical lion.'), " +
            "(59, 'Stardust', 'fantasy', 2007, 'Matthew Vaughn', 7.6, 'In a countryside town bordering on a magical land, a young man makes a promise to his beloved that he''ll retrieve a fallen star by venturing into the magical realm.'), " +
            "(60, 'Alice in Wonderland', 'fantasy', 2010, 'Tim Burton', 6.4, 'The adventure of nineteen-year-old Alice as she journeys through the whimsical and fantastical world of Wonderland.')"
        );
    }
    
    public void insertDataReview() throws SQLException {
        this.executeUpdateWithoutParms(
            "INSERT INTO Review (MovieId, Review) VALUES " +
            "(1, 'The Shawshank Redemption is a deeply moving film about hope and friendship. The scene where Andy plays the opera music over the loudspeakers is unforgettable.'), " +
            "(2, 'The Godfather is a masterpiece. The transformation of Michael Corleone is both tragic and compelling. Every scene is meticulously crafted.'), " +
            "(3, 'Schindler’s List is a harrowing depiction of the Holocaust. The girl in the red coat is a haunting image that stays with you.'), " +
            "(4, 'Forrest Gump is a heartwarming journey through American history. Forrest’s innocence and kindness make this film truly special.'), " +
            "(5, 'Fight Club is a mind-bending exploration of identity and consumerism. The twist at the end left me speechless.'), " +
            "(6, 'Goodfellas is an exhilarating look at the rise and fall of a gangster. The one-shot scene through the nightclub is iconic.'), " +
            "(7, 'The Green Mile is a touching and emotional film. John Coffey’s story is both heartbreaking and inspiring.'), " +
            "(8, 'Saving Private Ryan is an intense and realistic portrayal of World War II. The opening D-Day scene is incredibly powerful.'), " +
            "(9, 'The Pianist is a poignant story of survival. Adrien Brody’s performance is truly mesmerizing.'), " +
            "(10, 'Gladiator is an epic tale of revenge and redemption. The arena scenes are both brutal and thrilling.'), " +
            "(11, 'Inception is a visually stunning and intellectually challenging film. The concept of dreams within dreams is fascinating.'), " +
            "(12, 'The Dark Knight redefines the superhero genre. Heath Ledger’s Joker is chilling and unforgettable.'), " +
            "(13, 'Gladiator is a masterfully crafted epic. Russell Crowe delivers a powerful performance as Maximus.'), " +
            "(14, 'Mad Max: Fury Road is a non-stop thrill ride. The action sequences are some of the best ever filmed.'), " +
            "(15, 'Die Hard is a perfect action movie. Bruce Willis as John McClane is iconic, and the film is full of unforgettable moments.'), " +
            "(16, 'The Matrix is a groundbreaking sci-fi film. The action scenes and special effects are revolutionary.'), " +
            "(17, 'Terminator 2: Judgment Day is an incredible sequel. The liquid metal Terminator is a brilliant antagonist.'), " +
            "(18, 'The Avengers is a fantastic superhero team-up. The chemistry between the characters is great, and the action is top-notch.'), " +
            "(19, 'The Bourne Identity is a gripping spy thriller. The car chase in Paris is one of the best I’ve seen.'), " +
            "(20, 'Casino Royale reboots the Bond franchise with style. Daniel Craig brings a new intensity to the role.'), " +
            "(21, 'Lethal Weapon is a classic buddy cop movie. The chemistry between Mel Gibson and Danny Glover is perfect.'), " +
            "(22, 'Pulp Fiction is a wildly entertaining film. The dialogue is sharp, and the intertwined stories are brilliantly executed.'), " +
            "(23, 'The Big Lebowski is a hilarious and unique comedy. The Dude is one of the most memorable characters ever.'), " +
            "(24, 'Groundhog Day is a clever and heartwarming film. Bill Murray’s performance is both funny and touching.'), " +
            "(25, 'Monty Python and the Holy Grail is an absurd and hilarious take on the Arthurian legend. Every scene is packed with laughs.'), " +
            "(26, 'Superbad is a hilarious coming-of-age comedy. The friendship between the main characters is both funny and relatable.'), " +
            "(27, 'Anchorman: The Legend of Ron Burgundy is a laugh-out-loud comedy. Will Ferrell is perfect as the clueless news anchor.'), " +
            "(28, 'Step Brothers is a riotous comedy. The chemistry between Will Ferrell and John C. Reilly is fantastic.'), " +
            "(29, 'Dumb and Dumber is a classic comedy. Jim Carrey and Jeff Daniels deliver brilliant performances.'), " +
            "(30, 'Tropic Thunder is a hilarious and biting satire of Hollywood. The performances are over-the-top and perfect for the film.'), " +
            "(31, 'Borat is an outrageous and daring comedy. Sacha Baron Cohen pushes boundaries in the best way possible.'), " +
            "(32, 'Shaun of the Dead is a brilliant blend of comedy and horror. Simon Pegg and Nick Frost are a fantastic duo.'), " +
            "(33, 'The Exorcist is a terrifying horror classic. The special effects and atmosphere are still chilling today.'), " +
            "(34, 'The Shining is a haunting and atmospheric horror film. Jack Nicholson’s descent into madness is both frightening and fascinating.'), " +
            "(35, 'Psycho is a masterclass in suspense. Alfred Hitchcock’s direction and the iconic shower scene are unforgettable.'), " +
            "(36, 'Alien is a tense and claustrophobic sci-fi horror. The creature design and atmosphere are incredible.'), " +
            "(37, 'Jaws is a masterfully crafted thriller. The suspense and tension build perfectly throughout the film.'), " +
            "(38, 'The Silence of the Lambs is a chilling thriller. Anthony Hopkins as Hannibal Lecter is both terrifying and captivating.'), " +
            "(39, 'A Nightmare on Elm Street introduces one of the most iconic villains in horror. The concept of dying in your dreams is truly terrifying.'), " +
            "(40, 'The Thing is a paranoid and intense sci-fi horror. The practical effects are some of the best ever made.'), " +
            "(41, 'Get Out is a smart and socially relevant horror film. The tension and twists keep you on the edge of your seat.'), " +
            "(42, 'It is a thrilling and terrifying adaptation of Stephen King’s novel. The performances, especially Bill Skarsgård as Pennywise, are fantastic.'), " +
            "(43, 'Hereditary is a deeply unsettling horror film. The slow build and shocking moments make it incredibly effective.'), " +
            "(44, 'The Conjuring is a genuinely scary horror film. The atmosphere and scares are perfectly executed.'), " +
            "(45, 'Titanic is a sweeping romantic epic. The blend of historical tragedy and love story is captivating.'), " +
            "(46, 'Pride and Prejudice is a beautifully filmed adaptation. The performances and chemistry between the leads are fantastic.'), " +
            "(47, 'The Notebook is a heartfelt and emotional love story. The chemistry between the leads makes it unforgettable.'), " +
            "(48, 'La La Land is a vibrant and enchanting musical. The songs and performances are captivating.'), " +
            "(49, 'Casablanca is a timeless romantic classic. The dialogue and performances are legendary.'), " +
            "(50, 'A Walk to Remember is a touching and inspirational romance. The story and performances are deeply moving.'), " +
            "(51, 'Gone with the Wind is an epic romance set during the Civil War. The performances and scale of the film are grand.'), " +
            "(52, 'Eternal Sunshine of the Spotless Mind is a unique and thought-provoking film. The story of love and memory is beautifully told.'), " +
            "(53, 'Romeo + Juliet is a stylish and modern take on the classic tragedy. The visual style and performances are captivating.'), " +
            "(54, 'Notting Hill is a charming and delightful romantic comedy. The chemistry between Hugh Grant and Julia Roberts is perfect.'), " +
            "(55, 'The Lord of the Rings: The Fellowship of the Ring is a breathtaking fantasy epic. The world-building and story are incredible.'), " +
            "(56, 'Harry Potter and the Sorcerer''s Stone is a magical and enchanting introduction to the beloved series. The film captures the wonder of the books.'), " +
            "(57, 'Pan''s Labyrinth is a dark and imaginative fairy tale. The blend of fantasy and reality is beautifully done.'), " +
            "(58, 'The Chronicles of Narnia: The Lion, the Witch and the Wardrobe is a charming and adventurous film. The story and characters are captivating.'), " +
            "(59, 'Stardust is a whimsical and enchanting fantasy. The story and characters are delightful.'), " +
            "(60, 'Alice in Wonderland is a visually stunning journey. The imaginative world and characters are beautifully realized.')"
        );
    }
}

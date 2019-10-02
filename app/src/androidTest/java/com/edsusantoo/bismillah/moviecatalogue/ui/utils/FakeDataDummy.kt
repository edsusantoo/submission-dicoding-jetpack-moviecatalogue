package com.edsusantoo.bismillah.moviecatalogue.ui.utils

import com.edsusantoo.bismillah.moviecatalogue.data.local.other.MoviesModel
import com.edsusantoo.bismillah.moviecatalogue.utils.Constants

class FakeDataDummy {
    companion object {
        fun getMovies(): ArrayList<MoviesModel> {
            val movies = ArrayList<MoviesModel>()

            //aquaman
            val genresAquaman = ArrayList<String>()
            genresAquaman.add("Action")
            genresAquaman.add("Adventure")
            genresAquaman.add("Fantasy")
            movies.add(
                MoviesModel(
                    1,
                    "Aquaman",
                    "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                    "68%",
                    genresAquaman,
                    "https://",
                    Constants.MOVIE
                )
            )

            //A Star Is Born
            val genresIsBorn = ArrayList<String>()
            genresIsBorn.add("Drama")
            genresIsBorn.add("Romance")
            genresIsBorn.add("Music")
            movies.add(
                MoviesModel(
                    2,
                    "A Star Is Born",
                    "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                    "75%",
                    genresIsBorn,
                    "https://",
                    Constants.MOVIE
                )
            )

            //Avengers: Infinity War
            val genresInfinityWar = ArrayList<String>()
            genresInfinityWar.add("Adventure")
            genresInfinityWar.add("Action")
            genresInfinityWar.add("Science Fiction")
            movies.add(
                MoviesModel(
                    3,
                    "Avengers: Infinity War",
                    "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                    "83%",
                    genresInfinityWar,
                    "https://",
                    Constants.MOVIE
                )
            )

            //Bird Box
            val genresBirdBox = ArrayList<String>()
            genresBirdBox.add("Thriller")
            genresBirdBox.add("Drama")
            movies.add(
                MoviesModel(
                    4,
                    "Bird Box",
                    "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
                    "70%",
                    genresBirdBox,
                    "https://",
                    Constants.MOVIE
                )
            )

            //Bumblebee
            val genresBumblebee = ArrayList<String>()
            genresBumblebee.add("Adventure")
            genresBumblebee.add("Action")
            genresBumblebee.add("Science Fiction")
            movies.add(
                MoviesModel(
                    5,
                    "Bumblebee",
                    "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.",
                    "65%",
                    genresBumblebee,
                    "https://",
                    Constants.MOVIE
                )
            )

            //Creed II
            val genresCreed = ArrayList<String>()
            genresCreed.add("Drama")
            genresCreed.add("Action")
            genresCreed.add("Science Fiction")
            movies.add(
                MoviesModel(
                    6,
                    "Creed II",
                    "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                    "67%",
                    genresCreed,
                    "https://",
                    Constants.MOVIE
                )
            )

            //Once Upon a Deadpool
            val genresDeadpool = ArrayList<String>()
            genresDeadpool.add("Comedy")
            genresDeadpool.add("Action")
            movies.add(
                MoviesModel(
                    7,
                    "Once Upon a Deadpool",
                    "A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's.",
                    "69%",
                    genresDeadpool,
                    "https://",
                    Constants.MOVIE
                )
            )

            //How to Train Your Dragon: The Hidden World
            val genresHowToTrain = ArrayList<String>()
            genresHowToTrain.add("Animation")
            genresHowToTrain.add("Family")
            genresHowToTrain.add("Adventure")
            movies.add(
                MoviesModel(
                    8,
                    "How to Train Your Dragon: The Hidden World",
                    "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup's reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                    "77%",
                    genresHowToTrain,
                    "https://",
                    Constants.MOVIE
                )
            )

            //Dragon Ball Super: Broly
            val genresDragonBall = ArrayList<String>()
            genresDragonBall.add("Action")
            genresDragonBall.add("Adventure")
            genresDragonBall.add("Animation")
            genresDragonBall.add("Science Fiction")
            genresDragonBall.add("Comedy")
            movies.add(
                MoviesModel(
                    9,
                    "Dragon Ball Super: Broly",
                    "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup's reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                    "77%",
                    genresHowToTrain,
                    "https://",
                    Constants.MOVIE
                )
            )

            //Spider-Man: Into the Spider-Verse
            val genresSpiderman = ArrayList<String>()
            genresSpiderman.add("Action")
            genresSpiderman.add("Adventure")
            genresSpiderman.add("Animation")
            genresSpiderman.add("Science Fiction")
            genresSpiderman.add("Comedy")
            movies.add(
                MoviesModel(
                    10,
                    "Spider-Man: Into the Spider-Verse",
                    "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                    "84%",
                    genresSpiderman,
                    "https://",
                    Constants.MOVIE
                )
            )

            //Venom
            val genresVenom = ArrayList<String>()
            genresVenom.add("Science Fiction")
            genresVenom.add("Action")
            movies.add(
                MoviesModel(
                    11,
                    "Venom",
                    "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                    "66%",
                    genresSpiderman,
                    "https://",
                    Constants.MOVIE
                )
            )
            return movies
        }

        fun getTvShows(): ArrayList<MoviesModel> {
            val tvshows = ArrayList<MoviesModel>()

            //Arrow
            val genreArrow = ArrayList<String>()
            genreArrow.add("Crime")
            genreArrow.add("Drama")
            genreArrow.add("Mystery")
            genreArrow.add("Action & Adventure")
            tvshows.add(
                MoviesModel(
                    1,
                    "Arrow",
                    "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                    "58%",
                    genreArrow,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //Doom Patrol
            val genreDoomPatrol = ArrayList<String>()
            genreDoomPatrol.add("Crime")
            genreDoomPatrol.add("Drama")
            genreDoomPatrol.add("Mystery")
            genreDoomPatrol.add("Action & Adventure")
            tvshows.add(
                MoviesModel(
                    2,
                    "Doom Patrol",
                    "The Doom Patrol's members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                    "60%",
                    genreArrow,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //Dragon Ball
            val genreDragonBall = ArrayList<String>()
            genreDragonBall.add("Comedy")
            genreDragonBall.add("Sci-Fi & Fantasy")
            genreDragonBall.add("Animation")
            genreDragonBall.add("Action & Adventure")
            tvshows.add(
                MoviesModel(
                    3,
                    "Dragon Ball",
                    "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure that would change Goku's life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT.",
                    "70%",
                    genreDragonBall,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //Fairy Tail
            val genreFairyTail = ArrayList<String>()
            genreFairyTail.add("Comedy")
            genreFairyTail.add("Sci-Fi & Fantasy")
            genreFairyTail.add("Animation")
            genreFairyTail.add("Action & Adventure")
            tvshows.add(
                MoviesModel(
                    4,
                    "Fairy Tail",
                    "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                    "69%",
                    genreFairyTail,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //Family Guy
            val genreFamilyGuy = ArrayList<String>()
            genreFamilyGuy.add("Comedy")
            genreFamilyGuy.add("Animation")
            tvshows.add(
                MoviesModel(
                    5,
                    "Family Guy",
                    "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                    "65%",
                    genreFamilyGuy,
                    "https://",
                    Constants.MOVIE
                )
            )

            //The Flash
            val genreTheFlash = ArrayList<String>()
            genreTheFlash.add("Drama")
            genreTheFlash.add("Sci-Fi & Fantasy")
            tvshows.add(
                MoviesModel(
                    6,
                    "The Flash",
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become…The Flash.",
                    "66%",
                    genreTheFlash,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //Gotham
            val genreGotham = ArrayList<String>()
            genreGotham.add("Drama")
            genreGotham.add("Fantasy")
            genreGotham.add("Crime")
            tvshows.add(
                MoviesModel(
                    7,
                    "Gotham",
                    " Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                    "69%",
                    genreGotham,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //Grey\'s Anatomy
            val genreGrey = ArrayList<String>()
            genreGrey.add("Drama")
            tvshows.add(
                MoviesModel(
                    8,
                    "Grey's Anatomy",
                    "Follows the personal and professional lives of a group of doctors at Seattle's Grey Sloan Memorial Hospital.",
                    "63%",
                    genreGrey,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //Hanna
            val genreHanna = ArrayList<String>()
            genreHanna.add("Action & Adventure")
            genreHanna.add("Drama")
            tvshows.add(
                MoviesModel(
                    9,
                    "Hanna",
                    "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                    "66%",
                    genreGrey,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //Naruto Shipuden
            val genreNaruto = ArrayList<String>()
            genreNaruto.add("Animation")
            genreNaruto.add("Comedy")
            genreNaruto.add("Drama")
            tvshows.add(
                MoviesModel(
                    10,
                    "Naruto Shipuden",
                    "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization, Akatsuki.",
                    "76%",
                    genreNaruto,
                    "https://",
                    Constants.TVSHOW
                )
            )

            //NCIS
            val genreNCIS = ArrayList<String>()
            genreNCIS.add("Action & Adventure")
            genreNCIS.add("Crime")
            genreNCIS.add("Drama")
            tvshows.add(
                MoviesModel(

                    11,
                    "NCIS",
                    "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                    "67%",
                    genreNCIS,
                    "https://",
                    Constants.TVSHOW
                )
            )

            return tvshows

        }
    }
}
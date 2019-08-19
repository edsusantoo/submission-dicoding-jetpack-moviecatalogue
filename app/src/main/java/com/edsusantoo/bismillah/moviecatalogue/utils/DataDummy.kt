package com.edsusantoo.bismillah.moviecatalogue.utils

import com.edsusantoo.bismillah.moviecatalogue.R
import com.edsusantoo.bismillah.moviecatalogue.data.MoviesModel

class DataDummy {
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
                            "Aquaman",
                            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne.",
                            "68%",
                            genresAquaman,
                            R.drawable.poster_aquaman
                    )
            )

            //A Star Is Born
            val genresIsBorn = ArrayList<String>()
            genresIsBorn.add("Drama")
            genresIsBorn.add("Romance")
            genresIsBorn.add("Music")
            movies.add(
                    MoviesModel(
                            "A Star Is Born",
                            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally\\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                            "75%",
                            genresIsBorn,
                            R.drawable.poster_a_star
                    )
            )

            //Avengers: Infinity War
            val genresInfinityWar = ArrayList<String>()
            genresInfinityWar.add("Adventure")
            genresInfinityWar.add("Action")
            genresInfinityWar.add("Science Fiction")
            movies.add(
                    MoviesModel(
                            "Avengers: Infinity War",
                            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                            "83%",
                            genresInfinityWar,
                            R.drawable.poster_avengerinfinity
                    )
            )

            //Bird Box
            val genresBirdBox = ArrayList<String>()
            genresBirdBox.add("Thriller")
            genresBirdBox.add("Drama")
            movies.add(
                    MoviesModel(
                            "Bird Box",
                            "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
                            "70%",
                            genresBirdBox,
                            R.drawable.poster_birdbox
                    )
            )

            //Bumblebee
            val genresBumblebee = ArrayList<String>()
            genresBumblebee.add("Adventure")
            genresBumblebee.add("Action")
            genresBumblebee.add("Science Fiction")
            movies.add(
                    MoviesModel(
                            "Bumblebee",
                            "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.",
                            "65%",
                            genresBumblebee,
                            R.drawable.poster_bumblebee
                    )
            )

            //Creed II
            val genresCreed = ArrayList<String>()
            genresCreed.add("Drama")
            genresCreed.add("Action")
            genresCreed.add("Science Fiction")
            movies.add(
                    MoviesModel(
                            "Creed II",
                            "Between personal obligations and training for his next big fight against an opponent with ties to his family\\'s past, Adonis Creed is up against the challenge of his life.",
                            "67%",
                            genresCreed,
                            R.drawable.poster_creed
                    )
            )

            //Once Upon a Deadpool
            val genresDeadpool = ArrayList<String>()
            genresDeadpool.add("Comedy")
            genresDeadpool.add("Action")
            movies.add(
                    MoviesModel(
                            "Once Upon a Deadpool",
                            "A kidnapped Fred Savage is forced to endure Deadpool\\'s PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that\\'s full of magic, wonder & zero F\\'s.",
                            "69%",
                            genresDeadpool,
                            R.drawable.poster_deadpool
                    )
            )

            //How to Train Your Dragon: The Hidden World
            val genresHowToTrain = ArrayList<String>()
            genresHowToTrain.add("Animation")
            genresHowToTrain.add("Family")
            genresHowToTrain.add("Adventure")
            movies.add(
                    MoviesModel(
                            "How to Train Your Dragon: The Hidden World",
                            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless\\' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup\\'s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                            "77%",
                            genresHowToTrain,
                            R.drawable.poster_dragon
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
                            "Dragon Ball Super: Broly",
                            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless\\' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup\\'s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                            "77%",
                            genresHowToTrain,
                            R.drawable.poster_dragon_ball
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
                            "Spider-Man: Into the Spider-Verse",
                            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                            "84%",
                            genresSpiderman,
                            R.drawable.poster_spiderman
                    )
            )

            //Venom
            val genresVenom = ArrayList<String>()
            genresVenom.add("Science Fiction")
            genresVenom.add("Action")
            movies.add(
                    MoviesModel(
                            "Venom",
                            "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                            "66%",
                            genresSpiderman,
                            R.drawable.poster_venom
                    )
            )
            return movies
        }
//
//        fun getTvShows(): ArrayList<MoviesModel> {
//            val tvshows = ArrayList<MoviesModel>()
//
//
//
//        }
    }
}
package com.example.jetpack.model

import com.example.jetpack.R

object FakeDataSource {
    val dummyStories = listOf(
        Item(1, R.drawable.jervis, "Jervis Bay, Australia", "-8.834462, 115.151659","Australia’s Jervis Bay is actually home to the whitest sandy beach on the planet, but visitors don’t flock here for whiter-than-white sand. Okay, some do, but most head to this 102-square-kilometre oceanic bay for the magic that comes after dark. Jervis Bay is one of the few places on the planet where people can see the wonder of bioluminescence, as masses of plankton glow in the dark and give the water a gorgeously ethereal look." ),
        Item(2, R.drawable.zangye, "Zhangye Danxia, China", "-21.903544, 115.526563", "It\\'s easy to convince yourself that the swirling colours of China’s Zhangye Danxia mountains are actually a painting, but this gorgeous landscape is very, very real. The colours are thanks to the whimsical movements of mineral deposits over millennia, although it took just about that much time for China to pay much attention to it. "),
        Item(3, R.drawable.hillier, "Lake Hillier, Australia", "30.971304, 112.184297", "We wouldn’t ever claim to be expert limnologists, but we know enough about lakes to know that they aren’t usually pink. Not pink of any shade, let alone bright bubblegum pink, but that is the hue of Lake Hillier, a saline lake found on the edges of Middle Island in Western Australia. Algae, halobacteria and other microbes create this incredible scene"),
        Item(4, R.drawable.wales, "Green Bridge of Wales", "45.862196, 81.651825", "Natural arches are weird wherever they are, be it the mountains of Bosnia and Herzegovina or the massive arch found in Arches National Park, Utah. There is something beautifully fragile about the Green Bridge of Wales, however, and it’s accentuated by the sleepy serenity of the Pembrokeshire coast and that inimitable sense of poetry that flows out of this small nation"),
        Item(5, R.drawable.hell, "Darvaza Gas Crater, Turkmenistan", "68.994243, -8.834462", "he crater has been burning for decades, creating one of the most intense images on the planet, and visitors have flocked here for the sort of view that just shouldn’t be possible. Nobody really knows how it ignited, but we can only assume it had something to do with Beelzebub."),
        Item(6, R.drawable.moonbow, "Lunar Rainbow, Victoria Falls, Zambia", "112.184297, 94.148351", "A moonbow! No, it isn’t the fantastical creation of a children’s fiction writer, but a very real phenomenon found at the already-magnificent Victoria Falls in southern Africa. These nighttime rainbows are only visible when there is a considerable amount of spray splashing back from the powerful cascades,"),
        Item(7, R.drawable.thor, "Thor’s Well, USA", "30.971304, 112.184297", "Some people refer to Thor’s Well as the ‘Drainpipe of the Pacific’, but that just sounds downright disgusting. We’ll stick to Thor’s Well, a thrilling sinkhole that seems to suck the power of the ocean into its grasp at will. It is something of an oceanic black hole,"),
        Item(8, R.drawable.pamukle, "Pamukkale, Turkey", "-8.834462, 112.184297", "Pamukkale literally translates as ‘cotton castle’, and that feels like a particularly apt name for this incredible network of thermal waters found in the west of Turkey. The geothermal phenomenon has been attracting visitors looking for revitalisation for centuries, but it took designation as a Unesco World Heritage site for the area to be maintained and preserved"),
        Item(9, R.drawable.salt, "Uyuni Salt Flat, Bolivia", "-21.903544, 94.148351", "Human beings couldn’t survive without salt. The most important of all seasonings is responsible for a heck of a lot more than people realise, so there’s an extra special joy to the Uyuni Salt Flat. Of course, nobody really comes here to ponder the importance of salt"),
        Item(10, R.drawable.echoes, "Echo Beach, Indonesia", "76.490889, 65.177280", "Sand usually veers towards the lighter end of the colour scale, and this makes the black sand beaches of Bali all the more jarring. Jarring in a good way, obviously, as there is something otherworldly about wandering down a jet-black beach, hand-in-hand with your loved one, as the turquoise waters do their thing"),
    )

}

//model disatuin biar ga ribet

data class Item(
    val id: Long,
    val image: Int,
    val title: String,
    val coordinate: String,
    val description: String
)
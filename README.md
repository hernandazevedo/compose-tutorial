### Compose samples for the google codelabs

### Index
[Compose Tutorial Index](https://developer.android.com/courses/pathways/compose)

[Tutorial: Jetpack Compose basics](https://developer.android.com/jetpack/compose/tutorial?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23article-https%3A%2F%2Fdeveloper.android.com%2Fjetpack%2Fcompose%2Ftutorial)

# Jetpack Compose Tutorial

*   4 lessons
*   [Get setup >](/jetpack/compose/setup)

Jetpack Compose is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.

In this tutorial, you'll build a simple UI component with declarative functions. You won't be editing any XML layouts or using the Layout Editor. Instead, you will call Jetpack Compose functions to say what elements you want, and the Compose compiler will do the rest.

![Full Preview](/images/jetpack/compose-tutorial/00-hero-device.png)

*   4 lessons
*   [Get setup >](/jetpack/compose/setup)

![Full Preview](/images/jetpack/compose-tutorial/hero.png)<android-sticky-toc embedded="" class="android-sticky-toc" eyebrow-text="Tutorial" back-to-top-text="Learning the basics of Compose">Tutorial[Learning the basics of Compose](#top_of_page)

*   [1: Composable functions](#lesson-1:-composable-functions)
    *   [Add a text element](#add-a-text-element)
    *   [Define a composable function](#define-a-composable-function)
    *   [Preview your function in Android Studio](#preview-your-function-in-android-studio)
*   [2: Layouts](#lesson-2:-layouts)
    *   [Add multiple texts](#add-multiple-texts)
    *   [Using a Column](#using-a-column)
    *   [Add an image element](#add-an-image-element)
    *   [Configure your layout](#configure-your-layout)
*   [3: Material Design](#lesson-3:-material-design)
    *   [Use Material Design](#use-material-design)
    *   [Color](#color)
    *   [Typography](#typography)
    *   [Shape](#shape)
    *   [Enable dark theme](#enable-dark-theme)
*   [4: Lists and animations](#lesson-4:-lists-and-animations)
    *   [Create a list of messages](#create-a-list-of-messages)
    *   [Animate messages while expanding](#animate-messages-while-expanding)

</android-sticky-toc>[](#top_of_page)

## Lesson 1: Composable functions

Jetpack Compose is built around composable functions. These functions let you define your app's UI programmatically by describing how it should look and providing data dependencies, rather than focusing on the process of the UI's construction (initializing an element, attaching it to a parent, etc.). To create a composable function, just add the `@Composable` annotation to the function name.

![](/images/jetpack/compose-tutorial/lesson1-01.svg)<android-sticky-lesson lesson-id="1" step-ids="tut-step-1,tut-step-2,tut-step-3,tut-step-4">

#### Add a text element

To begin, download the most recent version of [Android Studio](https://developer.android.com/studio), and create an app using the Empty Compose Activity template. The default template already contains some Compose elements, but let's build it up step by step.

First, we’ll display a “Hello world!” text by adding a text element inside the `onCreate` method. You do this by defining a content block, and calling the `Text()` function. The `setContent` block defines the activity's layout where we call composable functions. Composable functions can only be called from other composable functions.

Jetpack Compose uses a Kotlin compiler plugin to transform these composable functions into the app's UI elements. For example, the `Text()` function that is defined by the Compose UI library displays a text label on the screen.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">class  MainActivity  :  ComponentActivity()  {    override  fun onCreate(savedInstanceState:  Bundle?)  {        super.onCreate(savedInstanceState)        **setContent {            Text("Hello world!")        }**    }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson1-02.png)

#### Define a composable function

To make a function composable, add the `@Composable` annotation. To try this out, define a `MessageCard()` function which is passed a name, and uses it to configure the text element.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">class  MainActivity  :  ComponentActivity()  {    override  fun onCreate(savedInstanceState:  Bundle?)  {        super.onCreate(savedInstanceState)        setContent {            **MessageCard("Android")**        }    }  
}  

**@Composable  
fun  MessageCard(name:  String)  {    Text(text =  "Hello $name!")  
}  
**  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson1-03.png)

#### Preview your function in Android Studio

[Android Studio](https://developer.android.com/studio) lets you preview your composable functions within the IDE, instead of installing the app to an Android device or emulator. The composable function must provide default values for any parameters. For this reason, you can't preview the `MessageCard()` function directly. Instead, let’s make a second function named `PreviewMessageCard()`, which calls `MessageCard()` with an appropriate parameter. Add the `@Preview` annotation before `@Composable`.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(name:  String)  {    Text(text =  "Hello $name!")  
}  

**@Preview  
@Composable  
fun  PreviewMessageCard()  {    MessageCard("Android")  
}**  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson1-03.png)

Rebuild your project. The app itself doesn't change, since the new `PreviewMessageCard()` function isn't called anywhere, but Android Studio adds a preview window. This window shows a preview of the UI elements created by composable functions marked with the `@Preview` annotation. To update the previews at any time, click the refresh button at the top of the preview window.

![](/images/jetpack/compose-tutorial/lesson1-04.png)

<figure>**Figure 1.** Using Android Studio to preview your composable functions.</figure>

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">class  MainActivity  :  ComponentActivity()  {    override  fun onCreate(savedInstanceState:  Bundle?)  {        super.onCreate(savedInstanceState)        **setContent {            Text("Hello world!")        }**    }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson1-02.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">class  MainActivity  :  ComponentActivity()  {    override  fun onCreate(savedInstanceState:  Bundle?)  {        super.onCreate(savedInstanceState)        setContent {            **MessageCard("Android")**        }    }  
}  

**@Composable  
fun  MessageCard(name:  String)  {    Text(text =  "Hello $name!")  
}  
**  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson1-03.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(name:  String)  {    Text(text =  "Hello $name!")  
}  

**@Preview  
@Composable  
fun  PreviewMessageCard()  {    MessageCard("Android")  
}**  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson1-03.png)![](/images/jetpack/compose-tutorial/lesson1-04.png)

<figure>**Figure 1.** Using Android Studio to preview your composable functions.</figure>

</android-sticky-lesson>[](#top_of_page)

## Lesson 2: Layouts

UI elements are hierarchical, with elements contained in other elements. In Compose, you build a UI hierarchy by calling composable functions from other composable functions.

![](/images/jetpack/compose-tutorial/lesson2-01.svg)<android-sticky-lesson lesson-id="2" step-ids="tut-step-1,tut-step-2,tut-step-3,tut-step-4,tut-step-5">

#### Add multiple texts

So far we’ve built our first composable function and preview! To discover more Jetpack Compose capabilities, we’re going to build a simple messaging screen containing a list of messages that can be expanded with some animations.  
Let’s start by making our message composable richer by displaying the name of its author and a message content. We need first to change our composable parameter to accept a `Message` object instead of a `String`, and add another `Text` composable inside the `MessageCard` composable. Make sure to update the preview as well:

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">class  MainActivity  :  ComponentActivity()  {    override  fun onCreate(savedInstanceState:  Bundle?)  {        super.onCreate(savedInstanceState)        setContent {            **MessageCard(Message("Android",  "Jetpack Compose"))**        }    }  
}  

**data class  Message(val author:  String,  val body:  String)  

@Composable  
fun  MessageCard(msg:  Message)  {    Text(text = msg.author)    Text(text = msg.body)  
}**  

@Preview  
@Composable  
fun  PreviewMessageCard()  {    **MessageCard(        msg =  Message("Colleague",  "Hey, take a look at Jetpack Compose, it's great!")    )**  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson2-02.png)

This code creates two text elements inside the content view. However, since we haven't provided any information about how to arrange them, the text elements are drawn on top of each other, making the text unreadable.

#### Using a Column

The `Column` function lets you arrange elements vertically. Add `Column` to the `MessageCard()` function.  
You can use Row to arrange items horizontally and Box to stack elements.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">**@Composable  
fun  MessageCard(msg:  Message)  {    Column  {        Text(text = msg.author)        Text(text = msg.body)    }  
}  
**  
</pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson2-04.png)

#### Add an image element

Let's enrich our message card by adding a profile picture of the sender. Use the [Resource Manager](https://developer.android.com/studio/write/resource-manager#import) to import an image from your photo library or use [this one](/images/jetpack/compose-tutorial/profile_picture.png). Add a `Row` composable to have a well structured design and an `Image` composable inside it:

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {    **Row  {        Image(            painter = painterResource(R.drawable.profile_picture),            contentDescription =  "Contact profile picture",        )    **  
       Column  {            Text(text = msg.author)            Text(text = msg.body)        }  **    }  **  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson2-05.png)

#### Configure your layout

Our message layout has the right structure but its elements aren't well spaced and the image is too big! To decorate or configure a composable, Compose uses **modifiers**. They allow you to change the composable's size, layout, appearance or add high-level interactions, such as making an element clickable. You can chain them to create richer composables. Let's use some of them to improve the layout:

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {    **// Add padding around our message    Row(modifier =  Modifier.padding(all =  8.dp))  {**        Image(            painter = painterResource(R.drawable.profile_picture),            contentDescription =  "Contact profile picture",            **modifier =  Modifier                // Set image size to 40 dp                .size(40.dp)                // Clip image to be shaped as a circle                .clip(CircleShape)**        )        **// Add a horizontal space between the image and the column        Spacer(modifier =  Modifier.width(8.dp))**        Column  {            Text(text = msg.author)            **// Add a vertical space between the author and message texts            Spacer(modifier =  Modifier.height(4.dp))**            Text(text = msg.body)        }    **}**  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson2-06.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">class  MainActivity  :  ComponentActivity()  {    override  fun onCreate(savedInstanceState:  Bundle?)  {        super.onCreate(savedInstanceState)        setContent {            **MessageCard(Message("Android",  "Jetpack Compose"))**        }    }  
}  

**data class  Message(val author:  String,  val body:  String)  

@Composable  
fun  MessageCard(msg:  Message)  {    Text(text = msg.author)    Text(text = msg.body)  
}**  

@Preview  
@Composable  
fun  PreviewMessageCard()  {    **MessageCard(        msg =  Message("Colleague",  "Hey, take a look at Jetpack Compose, it's great!")    )**  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson2-02.png)![](/images/jetpack/compose-tutorial/lesson2-03.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">**@Composable  
fun  MessageCard(msg:  Message)  {    Column  {        Text(text = msg.author)        Text(text = msg.body)    }  
}  
**  
</pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson2-04.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {    **Row  {        Image(            painter = painterResource(R.drawable.profile_picture),            contentDescription =  "Contact profile picture",        )    **  
       Column  {            Text(text = msg.author)            Text(text = msg.body)        }  **    }  **  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson2-05.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {    **// Add padding around our message    Row(modifier =  Modifier.padding(all =  8.dp))  {**        Image(            painter = painterResource(R.drawable.profile_picture),            contentDescription =  "Contact profile picture",            **modifier =  Modifier                // Set image size to 40 dp                .size(40.dp)                // Clip image to be shaped as a circle                .clip(CircleShape)**        )        **// Add a horizontal space between the image and the column        Spacer(modifier =  Modifier.width(8.dp))**        Column  {            Text(text = msg.author)            **// Add a vertical space between the author and message texts            Spacer(modifier =  Modifier.height(4.dp))**            Text(text = msg.body)        }    **}**  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson2-06.png)</android-sticky-lesson>[](#top_of_page)

## Lesson 3: Material Design

Compose is built to support Material Design principles. Many of its UI elements implement Material Design out of the box. In this lesson, you'll style your app with Material Design widgets.

![](/images/jetpack/compose-tutorial/lesson3-01.svg)<android-sticky-lesson lesson-id="3" step-ids="tut-step-1,tut-step-2,tut-step-3,tut-step-4,tut-step-5,tut-step-6">

#### Use Material Design

Our message design now has a layout, but it doesn't look too good yet.

Jetpack Compose provides an implementation of Material Design and its UI elements out of the box. We'll improve the appearance of our MessageCard composable using Material Design styling.

To start, we wrap our `MessageCard` function with the Material theme created in your project, `ComposeTutorialTheme` in this case. Do it both in the `@Preview` and in the `setContent` function.

Material Design is built around three pillars: Color, Typography, Shape. Let's add them one by one

**Note:** the Empty Compose Activity generates a default theme for your project that allows you to customize MaterialTheme. If you named your project anything different from ComposeTutorial, you can find your custom theme in the ui.theme package.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">class  MainActivity  :  ComponentActivity()  {    override  fun onCreate(savedInstanceState:  Bundle?)  {        super.onCreate(savedInstanceState)        **setContent {            ComposeTutorialTheme  {                MessageCard(Message("Android",  "Jetpack Compose"))            }        }**    }  
}  

**@Preview  
@Composable  
fun  PreviewMessageCard()  {    ComposeTutorialTheme  {        MessageCard(**            msg =  Message("Colleague",  "Take a look at Jetpack Compose, it's great!")        )    **}  
}**  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-02.png)

#### Color

Styling with colors from the wrapped theme is easy, and you can use values from the theme anywhere a color is needed.

Let's style the title and add a border to the image:

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {  
   Row(modifier =  Modifier.padding(all =  8.dp))  {  
       Image(           painter = painterResource(R.drawable.profile_picture),           contentDescription =  null,           modifier =  Modifier  
               .size(40.dp)  
               .clip(CircleShape)  
               **.border(1.5.dp,  MaterialTheme.colors.secondary,  CircleShape)**  
       )  

       Spacer(modifier =  Modifier.width(8.dp))  

       Column  {  
           **Text(               text = msg.author,               color =  MaterialTheme.colors.secondaryVariant  
           )**  

           Spacer(modifier =  Modifier.height(4.dp))  
           Text(text = msg.body)  
       }  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-03.png)

#### Typography

Material Typography styles are available in the MaterialTheme, just add them to the Text composables.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {  
   Row(modifier =  Modifier.padding(all =  8.dp))  {  
       Image(           painter = painterResource(R.drawable.profile_picture),           contentDescription =  null,           modifier =  Modifier  
               .size(40.dp)  
               .clip(CircleShape)  
               .border(1.5.dp,  MaterialTheme.colors.secondary,  CircleShape)  
       )  
       Spacer(modifier =  Modifier.width(8.dp))  

       Column  {  
           Text(               text = msg.author,               color =  MaterialTheme.colors.secondaryVariant,  
               **style =  MaterialTheme.typography.subtitle2**  
           )  

           Spacer(modifier =  Modifier.height(4.dp))  

           Text(               text = msg.body,  
               **style =  MaterialTheme.typography.body2**  
           )  
       }  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-04.png)

#### Shape

With Shape we can add the final touches. We also add padding to the message for a better layout.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {  
   Row(modifier =  Modifier.padding(all =  8.dp))  {  
       Image(           painter = painterResource(R.drawable.profile_picture),           contentDescription =  null,           modifier =  Modifier  
               .size(40.dp)  
               .clip(CircleShape)  
               .border(1.5.dp,  MaterialTheme.colors.secondary,  CircleShape)  
       )  
       Spacer(modifier =  Modifier.width(8.dp))  

       Column  {  
           Text(               text = msg.author,               color =  MaterialTheme.colors.secondaryVariant,               style =  MaterialTheme.typography.subtitle2  
           )  

           Spacer(modifier =  Modifier.height(4.dp))  

           **Surface(shape =  MaterialTheme.shapes.medium, elevation =  1.dp)  {**  
               Text(                   text = msg.body,  
                   **modifier =  Modifier.padding(all =  4.dp),**                   style =  MaterialTheme.typography.body2  
               )  
           **}**  
       }  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-05.png)

#### Enable dark theme

[Dark theme](https://developer.android.com/guide/topics/ui/look-and-feel/darktheme) (or night mode) can be enabled to avoid a bright display especially at night, or simply to save the device battery. Thanks to the Material Design support, Jetpack Compose can handle the dark theme by default. Having used Material Design colors, text and backgrounds will automatically adapt to the dark background.

You can create multiple previews in your file as separate functions, or add multiple annotations to the same function.

Let's add a new preview annotation and enable night mode.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Preview(name =  "Light Mode")  
**@Preview(    uiMode =  Configuration.UI_MODE_NIGHT_YES,    showBackground =  true,    name =  "Dark Mode"  
)**  
@Composable  
fun  PreviewMessageCard()  {  
   ComposeTutorialTheme  {  
       MessageCard(           msg =  Message("Colleague",  "Hey, take a look at Jetpack Compose, it's great!")  
       )  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-06.png)

Color choices for the light and dark themes are defined in the IDE-generated `Theme.kt` file.

So far, we've created a message UI element that displays an image and two texts with different styles, and it looks good both in light and dark themes!

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Preview(name =  "Light Mode")  
**@Preview(    uiMode =  Configuration.UI_MODE_NIGHT_YES,    showBackground =  true,    name =  "Dark Mode"  
)**  
@Composable  
fun  PreviewMessageCard()  {  
   ComposeTutorialTheme  {  
       MessageCard(           msg =  Message("Colleague",  "Hey, take a look at Jetpack Compose, it's great!")  
       )  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-06.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">class  MainActivity  :  ComponentActivity()  {    override  fun onCreate(savedInstanceState:  Bundle?)  {        super.onCreate(savedInstanceState)        **setContent {            ComposeTutorialTheme  {                MessageCard(Message("Android",  "Jetpack Compose"))            }        }**    }  
}  

**@Preview  
@Composable  
fun  PreviewMessageCard()  {    ComposeTutorialTheme  {        MessageCard(**            msg =  Message("Colleague",  "Take a look at Jetpack Compose, it's great!")        )    **}  
}**  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-02.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {  
   Row(modifier =  Modifier.padding(all =  8.dp))  {  
       Image(           painter = painterResource(R.drawable.profile_picture),           contentDescription =  null,           modifier =  Modifier  
               .size(40.dp)  
               .clip(CircleShape)  
               **.border(1.5.dp,  MaterialTheme.colors.secondary,  CircleShape)**  
       )  

       Spacer(modifier =  Modifier.width(8.dp))  

       Column  {  
           **Text(               text = msg.author,               color =  MaterialTheme.colors.secondaryVariant  
           )**  

           Spacer(modifier =  Modifier.height(4.dp))  
           Text(text = msg.body)  
       }  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-03.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {  
   Row(modifier =  Modifier.padding(all =  8.dp))  {  
       Image(           painter = painterResource(R.drawable.profile_picture),           contentDescription =  null,           modifier =  Modifier  
               .size(40.dp)  
               .clip(CircleShape)  
               .border(1.5.dp,  MaterialTheme.colors.secondary,  CircleShape)  
       )  
       Spacer(modifier =  Modifier.width(8.dp))  

       Column  {  
           Text(               text = msg.author,               color =  MaterialTheme.colors.secondaryVariant,  
               **style =  MaterialTheme.typography.subtitle2**  
           )  

           Spacer(modifier =  Modifier.height(4.dp))  

           Text(               text = msg.body,  
               **style =  MaterialTheme.typography.body2**  
           )  
       }  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-04.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {  
   Row(modifier =  Modifier.padding(all =  8.dp))  {  
       Image(           painter = painterResource(R.drawable.profile_picture),           contentDescription =  null,           modifier =  Modifier  
               .size(40.dp)  
               .clip(CircleShape)  
               .border(1.5.dp,  MaterialTheme.colors.secondary,  CircleShape)  
       )  
       Spacer(modifier =  Modifier.width(8.dp))  

       Column  {  
           Text(               text = msg.author,               color =  MaterialTheme.colors.secondaryVariant,               style =  MaterialTheme.typography.subtitle2  
           )  

           Spacer(modifier =  Modifier.height(4.dp))  

           **Surface(shape =  MaterialTheme.shapes.medium, elevation =  1.dp)  {**  
               Text(                   text = msg.body,  
                   **modifier =  Modifier.padding(all =  4.dp),**                   style =  MaterialTheme.typography.body2  
               )  
           **}**  
       }  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-05.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Preview(name =  "Light Mode")  
**@Preview(    uiMode =  Configuration.UI_MODE_NIGHT_YES,    showBackground =  true,    name =  "Dark Mode"  
)**  
@Composable  
fun  PreviewMessageCard()  {  
   ComposeTutorialTheme  {  
       MessageCard(           msg =  Message("Colleague",  "Hey, take a look at Jetpack Compose, it's great!")  
       )  
   }  
}  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson3-06.png)![](/images/jetpack/compose-tutorial/lesson3-07.png)</android-sticky-lesson>[](#top_of_page)

## Lesson 4: Lists and animations

Lists and animations are everywhere in apps. In this lesson, you will learn how Compose makes it easy to create lists and fun to add animations.

![](/images/jetpack/compose-tutorial/lesson4-01.svg)<android-sticky-lesson lesson-id="4" step-ids="tut-step-1,tut-step-2,tut-step-3">

#### Create a list of messages

A chat with one message feels a bit lonely, so let’s change our conversation to have more than one message. We need to create a `Conversation` function that will show multiple messages. For this use case, we can use Compose’s `LazyColumn` and `LazyRow.` These composables render only the elements that are visible on screen, so they are designed to be very efficient for long lists. At the same time, they avoid the complexity of `RecyclerView` with XML layouts.

In this code snippet, you can see that `LazyColumn` has an items child. It takes a `List` as a parameter and its lambda receives a parameter we’ve named `message` (we could have named it whatever we want) which is an instance of `Message`. In short, this lambda is called for each item of the provided `List`. Import this [sample dataset](https://gist.github.com/yrezgui/26a1060d67bf0ec2a73fa12695166436) into your project to help bootstrap the conversation quickly.

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">**import androidx.compose.foundation.lazy.items  

@Composable  
fun  Conversation(messages:  List<Message>)  {    LazyColumn  {  
        items(messages)  { message ->            MessageCard(message)        }    }  
}  

@Preview  
@Composable  
fun  PreviewConversation()  {    ComposeTutorialTheme  {        Conversation(SampleData.conversationSample)    }  
}**  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson4-02.png)

#### Animate messages while expanding

Our conversation is getting more interesting. It's time to play with animations! We will add the ability to expand a message to show a longer one, animating both the content size and the background color. To store this local UI state, we need to keep track of whether a message has been expanded or not. To keep track of this state change, we have to use the functions `remember` and `mutableStateOf`.

Composable functions can store local state in memory by using `remember`, and track changes to the value passed to `mutableStateOf`. Composables (and their children) using this state will get redrawn automatically when the value is updated. We call this [recomposition](https://developer.android.com/jetpack/compose/mental-model#recomposition).

By using Compose’s state APIs like `remember` and `mutableStateOf`, any changes to state automatically update the UI.

**Note:** You will need to add the following imports to correctly use `by`. Alt+Enter or Option+Enter adds them for you.

`import androidx.compose.runtime.getValue import androidx.compose.runtime.setValue`<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">**class  MainActivity  :  ComponentActivity()  {  
   override  fun onCreate(savedInstanceState:  Bundle?)  {  
       super.onCreate(savedInstanceState)       setContent {  
           ComposeTutorialTheme  {  
               Conversation(SampleData.conversationSample)  
           }  
       }  
   }  
}**  

@Composable  
fun  MessageCard(msg:  Message)  {    Row(modifier =  Modifier.padding(all =  8.dp))  {        Image(            painter = painterResource(R.drawable.profile_picture),            contentDescription =  null,            modifier =  Modifier                .size(40.dp)                .clip(CircleShape)                .border(1.5.dp,  MaterialTheme.colors.secondaryVariant,  CircleShape)        )        Spacer(modifier =  Modifier.width(8.dp))        **// We keep track if the message is expanded or not in this        // variable        var isExpanded by remember { mutableStateOf(false)  }        // We toggle the isExpanded variable when we click on this Column        Column(modifier =  Modifier.clickable { isExpanded =  !isExpanded })  {**            Text(                text = msg.author,                color =  MaterialTheme.colors.secondaryVariant,                style =  MaterialTheme.typography.subtitle2            )            Spacer(modifier =  Modifier.height(4.dp))            Surface(                shape =  MaterialTheme.shapes.medium,                elevation =  1.dp,            )  {                **Text(                    text = msg.body,                    modifier =  Modifier.padding(all =  4.dp),                    // If the message is expanded, we display all its content                    // otherwise we only display the first line                    maxLines =  if  (isExpanded)  Int.MAX_VALUE else  1,                    style =  MaterialTheme.typography.body2                )**            }        **}**    }  
}  </pre>

</devsite-code>show previewhide preview

Now we can change the background of the message content based on `isExpanded` when we click on a message. We will use the `clickable` modifier to handle click events on the composable. Instead of just toggling the background color of the `Surface`, we will animate the background color by gradually modifying its value from `MaterialTheme.colors.surface` to `MaterialTheme.colors.primary` and vice versa. To do so, we will use the `animateColorAsState` function. Lastly, we will use the `animateContentSize` modifier to animate the message container size smoothly:

<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {    Row(modifier =  Modifier.padding(all =  8.dp))  {        Image(            painter = painterResource(R.drawable.profile_picture),            contentDescription =  null,            modifier =  Modifier                .size(40.dp)                .clip(CircleShape)                .border(1.5.dp,  MaterialTheme.colors.secondaryVariant,  CircleShape)        )        Spacer(modifier =  Modifier.width(8.dp))        // We keep track if the message is expanded or not in this        // variable        var isExpanded by remember { mutableStateOf(false)  }        **// surfaceColor will be updated gradually from one color to the other        val surfaceColor:  Color by animateColorAsState(            if  (isExpanded)  MaterialTheme.colors.primary else  MaterialTheme.colors.surface,        )**        // We toggle the isExpanded variable when we click on this Column        Column(modifier =  Modifier.clickable { isExpanded =  !isExpanded })  {            Text(                text = msg.author,                color =  MaterialTheme.colors.secondaryVariant,                style =  MaterialTheme.typography.subtitle2            )            Spacer(modifier =  Modifier.height(4.dp))            Surface(                shape =  MaterialTheme.shapes.medium,                elevation =  1.dp,                **// surfaceColor color will be changing gradually from primary to surface                color = surfaceColor,                // animateContentSize will change the Surface size gradually                modifier =  Modifier.animateContentSize().padding(1.dp)**            )  {                Text(                    text = msg.body,                    modifier =  Modifier.padding(all =  4.dp),                    // If the message is expanded, we display all its content                    // otherwise we only display the first line                    maxLines =  if  (isExpanded)  Int.MAX_VALUE else  1,                    style =  MaterialTheme.typography.body2                )            }        }    }  
}  </pre>

</devsite-code>show previewhide preview<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">**import androidx.compose.foundation.lazy.items  

@Composable  
fun  Conversation(messages:  List<Message>)  {    LazyColumn  {  
        items(messages)  { message ->            MessageCard(message)        }    }  
}  

@Preview  
@Composable  
fun  PreviewConversation()  {    ComposeTutorialTheme  {        Conversation(SampleData.conversationSample)    }  
}**  </pre>

</devsite-code>show previewhide preview![](/images/jetpack/compose-tutorial/lesson4-02.png)<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">**class  MainActivity  :  ComponentActivity()  {  
   override  fun onCreate(savedInstanceState:  Bundle?)  {  
       super.onCreate(savedInstanceState)       setContent {  
           ComposeTutorialTheme  {  
               Conversation(SampleData.conversationSample)  
           }  
       }  
   }  
}**  

@Composable  
fun  MessageCard(msg:  Message)  {    Row(modifier =  Modifier.padding(all =  8.dp))  {        Image(            painter = painterResource(R.drawable.profile_picture),            contentDescription =  null,            modifier =  Modifier                .size(40.dp)                .clip(CircleShape)                .border(1.5.dp,  MaterialTheme.colors.secondaryVariant,  CircleShape)        )        Spacer(modifier =  Modifier.width(8.dp))        **// We keep track if the message is expanded or not in this        // variable        var isExpanded by remember { mutableStateOf(false)  }        // We toggle the isExpanded variable when we click on this Column        Column(modifier =  Modifier.clickable { isExpanded =  !isExpanded })  {**            Text(                text = msg.author,                color =  MaterialTheme.colors.secondaryVariant,                style =  MaterialTheme.typography.subtitle2            )            Spacer(modifier =  Modifier.height(4.dp))            Surface(                shape =  MaterialTheme.shapes.medium,                elevation =  1.dp,            )  {                **Text(                    text = msg.body,                    modifier =  Modifier.padding(all =  4.dp),                    // If the message is expanded, we display all its content                    // otherwise we only display the first line                    maxLines =  if  (isExpanded)  Int.MAX_VALUE else  1,                    style =  MaterialTheme.typography.body2                )**            }        **}**    }  
}  </pre>

</devsite-code>show previewhide preview<devsite-code dark-code="" class="dac-tutorial-code" data-copy-event-label="">

<pre is-upgraded="" class="lang-kotlin dac-compose-snippet devsite-code-highlight" translate="no" dir="ltr">@Composable  
fun  MessageCard(msg:  Message)  {    Row(modifier =  Modifier.padding(all =  8.dp))  {        Image(            painter = painterResource(R.drawable.profile_picture),            contentDescription =  null,            modifier =  Modifier                .size(40.dp)                .clip(CircleShape)                .border(1.5.dp,  MaterialTheme.colors.secondaryVariant,  CircleShape)        )        Spacer(modifier =  Modifier.width(8.dp))        // We keep track if the message is expanded or not in this        // variable        var isExpanded by remember { mutableStateOf(false)  }        **// surfaceColor will be updated gradually from one color to the other        val surfaceColor:  Color by animateColorAsState(            if  (isExpanded)  MaterialTheme.colors.primary else  MaterialTheme.colors.surface,        )**        // We toggle the isExpanded variable when we click on this Column        Column(modifier =  Modifier.clickable { isExpanded =  !isExpanded })  {            Text(                text = msg.author,                color =  MaterialTheme.colors.secondaryVariant,                style =  MaterialTheme.typography.subtitle2            )            Spacer(modifier =  Modifier.height(4.dp))            Surface(                shape =  MaterialTheme.shapes.medium,                elevation =  1.dp,                **// surfaceColor color will be changing gradually from primary to surface                color = surfaceColor,                // animateContentSize will change the Surface size gradually                modifier =  Modifier.animateContentSize().padding(1.dp)**            )  {                Text(                    text = msg.body,                    modifier =  Modifier.padding(all =  4.dp),                    // If the message is expanded, we display all its content                    // otherwise we only display the first line                    maxLines =  if  (isExpanded)  Int.MAX_VALUE else  1,                    style =  MaterialTheme.typography.body2                )            }        }    }  
}  </pre>

</devsite-code></android-sticky-lesson>

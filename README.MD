README.MD
-----

**Pre Requisites**
* Use Android Studio Beta (Arctic Fox) or Preview to open and update this project.
* DO NOT USE Android Studio Stable -- It's unlikely this will work.

**ATM Code Challenge**
Today's code challenge is straight forward. Inside this project you'll find some files which contain an activity, fragment, and a networking service. The goal here is to fetch some data and display the data matching the designs. Some of the work has even been done for you!

The designs are in the project saved as `Designs.png`. Note that there are two screens, but our project so far only has one fragment. You'll need to make a second one! Navigate to that second screen when a user selects an element on the first course list screen.

On the 2nd screen. Show More should be clickable and expand the text. When expanded, it should say "Show Less" and when clicked do the opposite.

On the 2nd screen. The `Start` button should show a toast which says "Course with ID: ${course.id} Started". 

As currently implemented networking may be happening on the main thread... consider an approach which takes that work off the main thread.

**Assumptions**
* If a course has a reward type `PL`, go ahead and assume that means "advocado". An asset file is included in the project.

* If a course does not have a `bannerImageUrl` or a `previewImageUrl` go ahead and use any solid color to display as the image. Note here that the preview image should display on the list screen and the banner image should display on the detail screen.

**What we look for**

* App architecture 
* Code structure
* Code cleanliness
* Extensibility
* That you generally followed our instructions

**What we don't look for**

* App designs match exactly. Exact padding, font weight, font sizing is not included. Use good judgement, but please don't spend too too much time here.

* Whether you use Jetpack Compose or Android Views to complete this challenge


**Not Required for implemention, but consider the following:**

* Configuring an MVVM Architecture with ViewModel
* Swapping to Jetpack Navigation vs currently implemented fragment transaction
* Extend the Service to save to a database -- without changing the interface
* Light vs Dark Themes
* Support Rotation

**What to submit** 
Please keep all files you wish to submit within this project folder. Zip it up and email it back to us. We'll review and get back to you as quickly as we can.

Thank you!
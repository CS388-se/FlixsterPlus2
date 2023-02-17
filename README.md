# Android Project 4 - *FlixsterPlus2*

Submitted by: **Stephen Ebrahim**

**FlixsterPlus2** is a movie browsing app that allows users to browse through the current most popular movies and TV shows as well as get more information about them!

Time spent: **6** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **Choose any endpoint on The MovieDB API except `now_playing`**
  - Chosen Endpoint: `movie/popular`, and `tv/popular`
- [X] **Make a request to your chosen endpoint and implement a RecyclerView to display all entries**
- [X] **Use Glide to load and display at least one image per entry**
- [X] **Click on an entry to view specific details about that entry using Intents**

The following **optional** features are implemented:

- [X] **Add another API call and RecyclerView that lets the user interact with different data.** 
- [X] **Add rounded corners to the images using the Glide transformations**
- [ ] **Implement a shared element transition when user clicks into the details of a movie**

## Video Walkthrough

Here's a walkthrough of implemented user stories:

![Kapture 2023-02-17 at 16 07 33](https://user-images.githubusercontent.com/66531257/219793552-fccdcdcf-6105-4e16-a5d1-a0789d7925f3.gif)

GIF created with [Kap](https://getkap.co/).

## Additional Code Proof
**Note: These images are to show the some of the implemented required and optional features that are not completely obvious from the GIF.**


New Endpoints used: `movie/popular` and `tv/popular`

![Screenshot 2023-02-17 at 4 10 28 PM](https://user-images.githubusercontent.com/66531257/219793919-575f63c8-411d-43b1-ac1a-4d20852b8278.png)
![Screenshot 2023-02-17 at 4 10 49 PM](https://user-images.githubusercontent.com/66531257/219793975-0419bf3d-dd82-4033-9418-33c8ae571cf7.png)

Rounded Corners using Glide transformations:

![Screenshot 2023-02-17 at 4 15 07 PM](https://user-images.githubusercontent.com/66531257/219794695-ddc42a1d-684f-40a2-a24b-1642253db44f.png)

## Notes

Describe any challenges encountered while building the app:

A challenge encountered when building the app was making sure that the class types (that represent that data that was parsed) was correctly implemented. I initially forgot that this class must extend java.io.Serializable and faces many issues.

## License

    Copyright [2023] [Stephen Ebrahim]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

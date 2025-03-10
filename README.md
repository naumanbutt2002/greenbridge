![GREEN BOARD](https://github.com/user-attachments/assets/49bf50cc-cced-40c5-a4e4-eaa0f5842ce1)

# Green Bridge - Exam Preparation App

![Platform](https://img.shields.io/badge/platform-%20Android-brightgreen)
![Version](https://img.shields.io/badge/version-1.0.0-blue)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction
**Green Bridge** is an advanced **exam preparation app** designed to help students excel in **JAMB, WAEC, and NECO**. Built using **Jetpack Compose and Kotlin**, it delivers a **modern, responsive, and user-friendly** experience.

With **real-time performance tracking, a practice mode, and full mock exams**, students can prepare effectively. **Offline support** ensures seamless study sessions anytime, anywhere.
## Features

- **Real-Time Performance Tracking:** Track scores and progress.
- **Practice Mode & Mock Exams:** Simulate real exam conditions.
- **Subject-Wise Questions:** Access a vast question bank for different subjects.
- **Offline Access:** Study without an internet connection.
- **Jetpack Compose UI**: Smooth, modern, and visually appealing UI.
- **Dark Mode Support**: Reduce eye strain during late-night study sessions.

## Screenshots
| ![HOMEPAGE](https://github.com/user-attachments/assets/248b3281-8d1d-4eff-9857-a46a8762e967) | ![EXAM MODE](https://github.com/user-attachments/assets/c2bc1b7d-effd-44da-be92-a064c3c217f4) |
|:---------------------------------------:|:--------------------------------------:|
| *HomePage Screen*                           | *Exam Screen*                   |

| ![TIMETABLE-2](https://github.com/user-attachments/assets/aa14c1e2-de6c-448f-bdd9-fcc5ea6df336) |  ![PAST QUESTIONS](https://github.com/user-attachments/assets/7b6739d0-2208-4adc-9157-041cd5b09733) |
|:-----------------------------------------:|:----------------------------------------------------:|
| *Timetable Screen*      | *Past Questions Screen*                           |

## Installation

### Prerequisites

- **Android Studio** – Download and install [here](https://developer.android.com/studio)
- **Java 11+** – Ensure Java is installed.
- **Gradle** – Latest version for Android development.
### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/naumanbutt2002/greenbridge.git
2. Navigate to the project directory:
   ```bash
   cd greenbridge
3. Open in Android Studio:
  - Open Android Studio and select **Open an Existing Project**.
  - Choose the **Green Bridge** project folder.
4. Build and Run the App:
   ```bash
   ./gradlew assembleDebug
  - Or simply click **Run** inside Android Studio.
   
## Usage
### Getting Started:
- Open the app and select a subject to start practicing.
- Choose between Practice Mode and Mock Exams.
  
### Performance Tracking:
- View your score history, strengths, and weaknesses.
- Get personalized recommendations on subjects to improve.
### Offline Mode:
- Download exam questions and practice offline.
- Access all features without internet connectivity.

## Technologies Used
- 🚀 **Jetpack Compose** – Modern UI Toolkit.
- 🚀 **Kotlin** – Main programming language.
- 🚀 **Room Database** – Stores practice questions locally.
- 🚀 **Coroutines & Flow** – Manages background tasks efficiently.
- 🚀 **Material Design 3** – Ensures sleek UI components.
  
## Architecture
This project follows MVVM (Model-View-ViewModel) for better scalability.
  
### Folder Structure
   ```bash
app/
├── data/
│   ├── database/
│   ├── repositories/
│   └── models/
├── domain/
│   ├── usecases/
├── presentation/
│   ├── viewmodels/
│   ├── screens/
|       ├── home_screen.kt
|       ├── mock_exam_screen.kt
|       ├── practice_mode_screen.kt
│   └── components/


```
### Why MVVM?
- ✔ Separation of Concerns – Makes code easier to maintain.
- ✔ LiveData & StateFlow – For real-time UI updates.
  
## Roadmap
- - [x] Initial release with core features.
- - [ ] AI-powered Study Recommendations 📈
- - [ ] Text-to-Speech for Question Reading 🔊
- - [ ] Release version 1.0.

## Contributing
Contributions are welcome! Please follow the steps below:

1. Fork the repository.
2. Create a new branch ('**git checkout -b feature-branch**').
3. Make your changes.
4. Commit your changes ('**git commit -m 'Add some feature'**').
5. Push to the branch ('**git push origin feature-branch**').
6. Open a pull request.

Please ensure all contributions align with the Clean Architecture principles used in this project.

## License
Distributed under the [MIT](https://choosealicense.com/licenses/mit/) License. See LICENSE for more information.

## Contact
Muhammad Nauman</br>
naumanbutt2002@gmail.com</br>
[Linkedin](https://www.linkedin.com/in/muhammad-nauman-3746b718a//) | [Instagram](https://www.instagram.com/naumanbutt2002/)

You can also follow my GitHub Profile to stay updated about my latest projects: [Github](https://github.com/naumanbutt2002)

/*
    1. Video Catalog
    2. Video Video Add
    3. Video Rental Checkout
    4. Video Return
    5. Remove Video
*/

/* Code is not working..... */

import java.util.*;

import javax.swing.ViewportLayout;

public class VideoStore {

    Scanner sc = new Scanner(System.in);

    public class Video {
        public String videoName;
        public boolean rentalStatus = false;
    }

    public int videoListLength = 0;
    public Video[] videoArr = new Video[100];

    void videoCatalogueDisplay() {
        for (int i = 0; i < this.videoListLength; i++) {
            System.out.println(this.videoArr[i].videoName);
            if (this.videoArr[i].rentalStatus) {
                System.out.println("Status: UnAvailable");
            } else {
                System.out.println("Status: Available");

            }
            System.out.println("\n");
        }
    }

    void addVideo(String videoTitle) {
        Video tempVideo = new VideoStore.Video();
        tempVideo.videoName = videoTitle;
        this.videoArr[videoListLength] = tempVideo;
        this.videoListLength++;
    }

    void rentalCheckout(String videoTitle) {

        for (int i = 0; i < this.videoListLength; i++) {

            if ((videoTitle == (String) this.videoArr[i].videoName) &&
                    (!(this.videoArr[i].rentalStatus))) {
                System.out.println("Available\n" + this.videoArr[i].videoName + "\n");
                System.out.println("Renting Video Title: " + this.videoArr[i].videoName);
                this.videoArr[i].rentalStatus = true;
                return;
            } else if ((videoTitle == this.videoArr[i].videoName) &&
                    (this.videoArr[i].rentalStatus)) {
                System.out.println("UnAvailable\n" + videoArr[i].videoName + "\n");

                System.out.println("Video is already rented to somebody else");
                return;
            }

        }
        System.out.println("Video Not Found");
    }

    void videoReturn(String videoTitle) {
        for (int i = 0; i < this.videoListLength; i++) {
            if ((videoTitle == this.videoArr[i].videoName) && (!(this.videoArr[i].rentalStatus))) {
                System.out.println("Video was never rented");
                return;
            } else if ((videoTitle == this.videoArr[i].videoName) && (this.videoArr[i].rentalStatus)) {
                System.out.println("Returning Video Title: " + this.videoArr[i].videoName);
                this.videoArr[i].rentalStatus = false;
                return;
            }
        }
        System.out.println("Video Not Found");
    }

    void videoRemove(String videoTitle) {
        int foundIndex = -1;
        for (int i = 0; i < this.videoListLength; i++) {
            if (videoTitle == this.videoArr[i].videoName) {
                System.out.println("Removing Video: " + this.videoArr[i].videoName);
                foundIndex = i;
                this.videoListLength--;
            }
        }
        if (foundIndex == -1) {
            System.out.println("Video Not Found");
            return;
        }

        for (int i = foundIndex; i < this.videoListLength; i++) {
            this.videoArr[i] = this.videoArr[i + 1];
        }

    }

    public static void main(String[] args) {

        VideoStore videoStore = new VideoStore();

        Scanner sc = new Scanner(System.in);

        System.out.println("******Video Rental Store******");
        System.out.println("\t1. Display Video Catalogue");
        System.out.println("\t2. Add Video");
        System.out.println("\t3. Checkout Video");
        System.out.println("\t4. Return Video");
        System.out.println("\t5. Remove Video");
        System.out.println("\t6. Exit");
        System.out.println("\n");

        System.out.println("Enter your Choice: ");
        int choice = sc.nextInt();

        while (choice != 6) {
            switch (choice) {
                case 1:
                    System.out.println("Total Videos: " + videoStore.videoListLength + "\n");
                    videoStore.videoCatalogueDisplay();
                    break;

                case 2:
                    System.out.println("Enter the Title of the Video you want to Add: ");
                    sc.nextLine();
                    String videoTitle = sc.nextLine();
                    videoStore.addVideo(videoTitle);
                    break;

                case 3:
                    System.out.println("Enter the Title of the Video you want to Checkout: ");
                    sc.nextLine();
                    videoTitle = sc.nextLine();
                    videoStore.rentalCheckout(videoTitle);
                    break;

                case 4:
                    System.out.println("Enter the Title of the Video you want to Return: ");
                    sc.nextLine();
                    videoTitle = sc.nextLine();
                    videoStore.videoReturn(videoTitle);
                    break;

                case 5:
                    System.out.println("Enter the Title of the video you want to remove: ");
                    sc.nextLine();
                    videoTitle = sc.nextLine();
                    videoStore.videoRemove(videoTitle);
                    break;

                default:
                    break;
            }

            System.out.println("\n\n");
            System.out.println("Enter your Choice: ");
            choice = sc.nextInt();

        }

    }

}
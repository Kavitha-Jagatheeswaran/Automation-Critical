package Keymethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


	public class Slackmessage {
	    public static void main(String[] args) {
	       
	        
	        // Initialize the WebDriver (in this case, we'll use Chrome).
	        WebDriver driver = new ChromeDriver();
	        
	        // Replace 'YOUR_SLACK_API_TOKEN' with your actual Slack API token.
	        String slackApiToken = "xoxe.xoxp-1-Mi0yLTMwNTg1ODM3OTQxNTAtMzU3Mzc4ODgxMzczMC01Njg2Nzg2OTk1MzE2LTU3MDgwMzg4OTEwODgtZTkyNzE0NzY3OTdmODIyM2Q3OGZkYmM2ZmU3ZGJkOWM0Nzk0M2MzYTIxMzMwODAyYzZkN2U0MTA3ZjMyOWVlMQ";
	        
	        // Replace 'CHANNEL_ID' with the ID of the Slack channel you want to send the message to.
	        String channelId = "D03GP4TP9SS";
	        
	        // The message you want to send.
	        String messageToSend = "Hello, this is a test message from Java Selenium!";
	        
	        // URL to the Slack API to post a message in a channel.
	        String apiUrl = "https://slack.com/api/chat.postMessage";
	        
	        // Open the Slack API URL with the necessary parameters to send the message.
	        String requestUrl = apiUrl + "?token=" + slackApiToken + "&channel=" + channelId + "&text=" + messageToSend;
	        driver.get(requestUrl);
	        
	        // Wait for a few seconds to allow the message to be sent.
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        // Close the WebDriver.
	        driver.quit();
	    }
	}



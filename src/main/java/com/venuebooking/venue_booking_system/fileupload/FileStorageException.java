package com.venuebooking.venue_booking_system.fileupload;

public class FileStorageException extends RuntimeException{

	public FileStorageException(String message) {
		super(message);
	}
	
	public FileStorageException(String message,Throwable cause) {
		super(message,cause);
	}
}

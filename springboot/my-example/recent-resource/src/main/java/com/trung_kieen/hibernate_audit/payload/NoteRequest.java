package com.trung_kieen.hibernate_audit.payload;

/**
 * NoteRequest
 */
public record NoteRequest(
    String title,
    String content) {
}

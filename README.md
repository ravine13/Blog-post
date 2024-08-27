# Blog-post

Entities and Relationships
User

id (Primary Key, Long): Unique identifier for the user.
username (String): Unique username for the user.
email (String): Email of the user.
password (String): Password for the user (hashed).
created_at (Timestamp): Timestamp when the user was created.
Relationship: One-to-Many with BlogPost, One-to-Many with Comment.
BlogPost

id (Primary Key, Long): Unique identifier for the blog post.
title (String): Title of the blog post.
content (Text): The body content of the blog post.
author (Foreign Key to User): The user who authored the post.
created_at (Timestamp): Timestamp when the blog post was created.
updated_at (Timestamp): Timestamp when the blog post was last updated.
Relationship: Many-to-One with User, One-to-Many with Comment.


Comment
id (Primary Key, Long): Unique identifier for the comment.
content (Text): The content of the comment.
user (Foreign Key to User): The user who made the comment.
blogPost (Foreign Key to BlogPost): The blog post on which the comment is made.
created_at (Timestamp): Timestamp when the comment was created.
Relationship: Many-to-One with User, Many-to-One with BlogPost.
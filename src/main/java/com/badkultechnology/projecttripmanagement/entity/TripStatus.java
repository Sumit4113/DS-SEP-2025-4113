package com.badkultechnology.projecttripmanagement.entity;

//So this is a TripStatus class that return type of TripStatus is itself — the enum type.
//In other words tripStatus is a custom data type that can only have one of three constant values:
//Hibernate will store the enum name (as a String) in your database column.

public enum TripStatus {
    PLANNED,
    ONGOING,
    COMPLETED
}
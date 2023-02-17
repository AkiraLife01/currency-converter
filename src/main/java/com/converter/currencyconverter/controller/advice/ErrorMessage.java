package com.converter.currencyconverter.controller.advice;

import java.util.Date;

// timestamp - current time at the moment
public record ErrorMessage(int statusCode, Date timestamp, String message, String description) {


}
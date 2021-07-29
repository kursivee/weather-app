package com.kursivee.weather.util

import arrow.core.Either
import com.kursivee.weather.network.ApplicationError

typealias AppResult<T> = Either<ApplicationError, T>

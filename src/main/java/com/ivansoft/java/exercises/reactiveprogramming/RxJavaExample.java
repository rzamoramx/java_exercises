package com.ivansoft.java.exercises.reactiveprogramming;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxJavaExample {
    public static void main(String[] args) {
        // Creates an Observable that emits a sequence of Integers within a specified range
        Observable<Integer> observable = Observable.range(1, 5);

        // Subscribes to the Observable and prints the emitted values
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                // code here to handle the subscription
                System.out.println("Subscribed to observable");
            }

            @Override
            public void onNext(Integer value) {
                // Code for handling the emitted value
                System.out.println("Emitted value: " + value);
            }

            @Override
            public void onError(Throwable e) {
                // code to handle the error
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                // Code for handling the completion
                System.out.println("Completed");
            }
        });
    }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Notebook} from "../models/Notebook";
import {Training} from "../models/Training";

@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  private BASE_URL = "http:localhost:8082/api/trainings";
  private GET_ALL_TRAININGS = `${this.BASE_URL}\\all`;
  private GET_TRAINING_BY_ID = this.BASE_URL;
  private SAVE_UPDATE_TRAINING = this.BASE_URL;
  private DELETE_TRAINING = this.BASE_URL;

  constructor(private  http: HttpClient) {}

  getAllTrainings(): Observable<Training[]> {

    return this.http.get<Training[]>(this.GET_ALL_TRAININGS);
  }
  postTraining(training: Training): Observable<Notebook> {

    return this.http.post<Notebook>(this.SAVE_UPDATE_TRAINING, training);
  }
  deleteTraining(id:string): Observable<any> {

    return this.http.delete(this.DELETE_TRAINING + id);
  }
  getTrainingById(id:string): Observable<Training> {
    return this.http.get<Notebook[]>(this.GET_TRAINING_BY_ID + id);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TrainingService {
  private BASE_URL = "http:localhost:8082/api/trainings";
  private GET_ALL_TRAININGS = `${this.BASE_URL}\\all`;
  private GET_TRAINING_BY_ID = this.BASE_URL;
  private SAVE_TRAINING = this.BASE_URL;
  private DELETE_TRAINING = this.BASE_URL;

  constructor(private http: HttpClient) { }
}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { BeerPage } from './beer.page';

import { BeerService } from '../../providers/beer-service';

const routes: Routes = [
  {
    path: '',
    component: BeerPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [BeerPage],
  providers: [
      BeerService
    ]
})
export class BeerPageModule {}

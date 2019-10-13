import {Comment} from './comment.model';

export class Advert {
  id: number;
  title: string;
  description: string;
  price: number;
  type: string;
  userId: number;
  categoryId: number;
  comments: Comment[];
}

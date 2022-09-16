import { TestBed } from '@angular/core/testing';

import { ListeArticleService } from './liste-article.service';

describe('ListeArticleService', () => {
  let service: ListeArticleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListeArticleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

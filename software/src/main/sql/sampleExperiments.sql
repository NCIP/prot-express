insert into experiment
  (id, name, description, hypothesis, url, creator, creation_date, modification_date, date_performed) values
  (nextval('hibernate_sequence'), 'Peroxisome membrane protein analysis, Marcello Marelli et al.', 'We have combined classical subcellular fractionation with large-scale quantitative mass spectrometry to identify proteins that enrich specifically with peroxisomes of Saccharomyces cerevisiae.', 'Some Hypothesis', 'http://www.jcb.org/cgi/content/abstract/167/6/1099', 'user1', current_date, current_date, current_date);

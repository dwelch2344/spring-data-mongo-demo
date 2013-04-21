# SpringData MongoDB Example

This project is a simple demo of a few SpringData MongoDB features. The important bits under the `co.ntier.examples.sdmongo` base package:

* `model.Person` - 
* `util.Auditable` & `util.AuditingUtil` - Shows an example of how easy it is to intercept your models as they are stored & retrieved in MongoDB. The example is contrived, but should give you a good idea of the flexibility.
* `repo.PersonRepository` - this is the real workhorse of SpringData I'd like to show. It's simply an interface that shows how SpringData gives you CRUD for free & how easy it is to add custom model-based lookups with **literally** no code.
* `DemoConfig` - A Spring JavaConfig file that shows just how easy it is to get started **without any XML**
* `Demo` - And finally, a simple command line app that allows you to run the code and see the bits and pieces working. Note that you'll need an instance of MongoDB running on your box w/ the default settings for this to work *out of the box* (if that's too much, update the `DemoConfig` as appropriate)



### Why did you do this?

Because it was fun and easy, as most software should be. Feel free to fork / clone / copy and use however you'd like.

### Why didn't you…

Did I do something wrong? Is there a better way of putting the pieces together? Great! Open an issue or submit a pull request! I'd love to learn from you!!

### Have questions?

I'd be happy to help. Contact me at [@david_welch](https://twitter.com/david_welch) or [Google+](https://plus.google.com/112934892720179657449/posts)
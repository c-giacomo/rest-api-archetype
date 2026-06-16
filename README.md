<h1>CREATE THE ARCHETYPE</h1>

<ul>
    <li>From the project root, run the following command in a terminal:</li>
</ul>

<pre><code>mvn archetype:create-from-project</code></pre>

<h1>THE ARCHETYPE IS GENERATED</h1>

<ul>
    <li>Run <code>mvn clean install</code> from the archetype root directory.</li>
    <li>In the folder where you want to create a project from the archetype, run:</li>
</ul>

<pre><code>mvn archetype:generate \
  -DarchetypeGroupId=[archetype.group.id] \
  -DarchetypeArtifactId=[archetype.artifact.id] \
  -DarchetypeVersion=[archetype.version]
</code></pre>
</div>
